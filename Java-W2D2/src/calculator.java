import java.util.InputMismatchException;
import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        try {
            System.out.println("Please enter your first number : ");
            double number1 = in.nextDouble();

            System.out.println("Please enter your second number : ");
            double number2 = in.nextDouble();

            System.out.println("Please enter the operation : ");
            String operation = in.next();


            if (operation.equals("+")) {
                System.out.println(number1 + number2);
            } else if (operation.equals("-")) {
                System.out.println(number1 - number2);
            } else if (operation.equals("*")) {
                System.out.println(number1 * number2);
            } else if (operation.equals("/")) {
                System.out.println(number1 / number2);
            } else if (operation.equals("%")) {
                System.out.println(number1 % number2);
            } else {
                System.out.println("Wrong operation!");
            }
        } catch (InputMismatchException e) {
                System.out.println(e.getStackTrace());

        }

    }
}