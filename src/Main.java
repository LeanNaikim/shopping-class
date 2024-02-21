
interface DiscountRate {
    double getServiceMemberDiscount();
    double getProductMemberDiscount();
}

class Customer implements DiscountRate {
    private String customerName;
    private String customerType;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }


    @Override
    public double getServiceMemberDiscount() {
        switch (customerType) {
            case "Premium":
                return  0.20;
            case "Gold":
                return  0.15;
            case "Silver":
                return  0.10;
            default:
                return  0.0;
        }
    }

    @Override
    public double getProductMemberDiscount() {
        switch (customerType) {
            case "Premium":
            case "Gold":
            case "Silver":
                return  0.10;
            default:
                return  0.0;
        }
    }
}
class Sale {
    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;

    public Sale(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double totalExpense = serviceExpense * (1 - customer.getServiceMemberDiscount())
                + productExpense * (1 - customer.getProductMemberDiscount());
        return totalExpense;
    }

    public void displayInfo() {
        System.out.println("Transaction Information:");
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Customer Type: " + customer.getCustomerType());
        System.out.println("Date: " + date);
        System.out.println("Service Expense: $" + serviceExpense);
        System.out.println("Product Expense: $" + productExpense);
        System.out.println("Total Expense: $" + getTotalExpense());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Customer premiumCustomer = new Customer("Susu", "Premium");
        Sale premiumSale = new Sale(premiumCustomer, "2024-02-21");
        premiumSale.setServiceExpense(100.0);
        premiumSale.setProductExpense(50.0);
        premiumSale.displayInfo();

        Customer goldCustomer = new Customer("kidkid", "Premium");
        Sale goldSale = new Sale(premiumCustomer, "2024-02-21");
        premiumSale.setServiceExpense(100.0);
        premiumSale.setProductExpense(50.0);
        premiumSale.displayInfo();

        Customer silverCustomer = new Customer("lulu", "Premium");
        Sale silerSale = new Sale(premiumCustomer, "2024-02-21");
        premiumSale.setServiceExpense(100.0);
        premiumSale.setProductExpense(50.0);
        premiumSale.displayInfo();

        Customer normalCustomer = new Customer("TenTen", "Premium");
        Sale normalSale = new Sale(premiumCustomer, "2024-02-21");
        premiumSale.setServiceExpense(100.0);
        premiumSale.setProductExpense(50.0);
        premiumSale.displayInfo();
    }
}
