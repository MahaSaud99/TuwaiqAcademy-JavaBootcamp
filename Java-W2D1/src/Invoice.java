public class Invoice {
    private int id;
    private Customer2 customer;
    private double amount;

    public Invoice(int id, Customer2 customer, double amount) {
        this.id = id;
        this.customer = new Customer2(customer.getId(),customer.getName(),customer.getDiscount());
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Customer2 getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setCustomer(Customer2 customer) {
        this.customer = customer;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId(){
       return this.customer.getId();
    }

    public String getCustomerName(){
        return this.customer.getName();
    }

    public int getCustomerDiscount(){
        return  this.customer.getDiscount();
    }

    public double getAmountAfterDiscount(){
        return this.amount-=this.amount*getCustomerDiscount()/100;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customer=" + customer +
                ", amount=" + amount +
                '}';
    }
}
