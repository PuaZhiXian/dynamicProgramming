public class No1518 {
    public static void main(String[] args) {
//        System.out.println(numWaterBottles(15, 4));
        System.out.println(numWaterBottles(9, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int drink = numBottles;
        while (numBottles >= numExchange) {
            int div = numBottles/ numExchange;
            int remainder = numBottles % numExchange;
            drink+= div;
            numBottles = div + remainder;
        }
        return drink;
    }

}
