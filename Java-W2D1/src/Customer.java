public class Customer{
    private int ID;
    private String name;
    private char gender;

    public Customer(int ID, String name, char gender) throws RuntimeException {
        if (gender!='m'&&gender!='f'){
            throw new RuntimeException("the gender is other than 'm' or 'f'");
        }
        this.ID = ID;
        this.name = name;
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", name=" + name +
                '}';
    }
}