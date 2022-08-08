public class DiscountRate {
    private static double serviceDiscountPremium=0.2;
    private static double serviceDiscountGold=0.15;
    private static double serviceDiscountSilver=0.1;
    private static double productDiscountPremium=0.1;
    private static double productDiscountGold=0.1;
    private static double productDiscountSilver=0.1;

    public double getServiceDiscountRate(String type) throws IllegalArgumentException{
        type=type.toLowerCase();
        if(type.equals("premium")){
            return serviceDiscountPremium*100;
        } else if (type.equals("gold")){
            return serviceDiscountGold*100;
        }else if(type.equals("silver")) {
            return serviceDiscountSilver*100;
        }else throw new IllegalArgumentException();
    }

    public double getProductDiscountRate(String type) throws IllegalArgumentException{
        type=type.toLowerCase();
        if(type.equals("premium")){
            return productDiscountPremium*100;
        } else if (type.equals("gold")){
            return productDiscountGold*100;
        }else if(type.equals("silver")) {
            return productDiscountSilver*100;
        }else throw new IllegalArgumentException();
    }





}
