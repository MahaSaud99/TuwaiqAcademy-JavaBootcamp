
public  class Account {
    private int id;
    private Customer customer;
    private double balance = 0;


    public Account(int id, Customer customer , double balance) {
        this.id = id;
        this.customer = new Customer(customer.getID(), customer.getName(), customer.getGender());
        this.balance = balance;
    }

    public Account(int id, Customer customer) {
        this.id = id;
        this.customer = new Customer(customer.getID(), customer.getName(), customer.getGender());
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + customer.getName() + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getCustomerName(){
        return customer.getName();
    }

    public Account deposit(double amount){
        this.balance+=amount;
        return this;
    }

    public Account withdraw(double amount){
        if (this.balance>=amount){
            this.balance-=amount;
            return this;
        }
        System.out.println("amount withdrawn exceeds the current balance!");
        return this;
    }
}