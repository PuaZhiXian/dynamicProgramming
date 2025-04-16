import java.util.ArrayList;
import java.util.List;

public class No1352 {

    public static void main(String[] args) {
        No1352 obj = new No1352();
        ProductOfNumbers product = obj.create();
        product.add(3);
        product.add(0);
        product.add(2);
        product.add(5);
        product.add(4);

        System.out.println(product.getProduct(2));
        System.out.println(product.getProduct(3));
        System.out.println(product.getProduct(4));
        product.add(8);
        System.out.println(product.getProduct(2));

    /*
productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
productOfNumbers.add(8);        // [3,0,2,5,4,8]
productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32 */
    }

    private ProductOfNumbers create() {
        return new ProductOfNumbers();
    }

    class ProductOfNumbers {


        private List<Long> list;

        public ProductOfNumbers() {
            list = new ArrayList<>();
        }

        public void add(int num) {
            if (list.isEmpty()) {
                list.add((long) num);
            } else {
                list.add(list.get(list.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            return Math.toIntExact(list.get(list.size() - 1) / list.get(k));
        }
    }

}
