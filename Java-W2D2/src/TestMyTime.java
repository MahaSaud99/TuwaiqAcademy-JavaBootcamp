public class TestMyTime {
    public static void main(String[] args) {

        try {

            System.out.println("------Test------");
            MyTime time = new MyTime(0, 0, 0);
            System.out.println(time);

            System.out.println("------Test setTime------");
            time.setTime(22,3,45);
            System.out.println(time);

            System.out.println("------Test nextSecond------");
            time.nextSecond();
            System.out.println(time);

            System.out.println("------Test nextMinute------");
            time.nextMinute();
            System.out.println(time);

            System.out.println("------Test nextHour------");
            time.nextHour();
            System.out.println(time);

            System.out.println("------Test previousSecond------");
            time.previousSecond();
            System.out.println(time);

            System.out.println("------Test previousMinute------");
            time.previousMinute();
            System.out.println(time);

            System.out.println("------Test previousHour------");
            time.previousHour();
            System.out.println(time);




        }catch (IllegalArgumentException e){
            System.out.println("Invalid hour, minute, or second!");
        }
    }

}
