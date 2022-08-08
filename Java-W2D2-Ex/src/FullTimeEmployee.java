public class FullTimeEmployee extends Employee{
    private int weeklySalary;

    public FullTimeEmployee(String name, int id, int weeklySalary) {
        super(name, id);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double computeAmount() {
        return this.weeklySalary*4;
    }
}
