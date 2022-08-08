import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<PayAble> list;

    public Company(String name) {
        this.name = name;
        list=new ArrayList<PayAble>();
    }

    public boolean add(PayAble p){
        list.add(p);
        return true;
    }

    public double computeAmount(){
        double amount=0;

        for (int i = 0; i < list.size(); i++) {
            amount+=list.get(i).computeAmount();
        }
        return amount;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
