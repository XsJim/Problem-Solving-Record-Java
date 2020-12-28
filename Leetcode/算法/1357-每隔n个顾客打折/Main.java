public class Main {
    public static void main(String[] args) {
        Cashier cas = new Cashier(3, 50, new int[] {1,2,3,4,5,6,7}, new int[] {100,200,300,400,300,200,100});
        System.out.println(cas.getBill(new int[] {1,2}, new int[] {1,2}));
        System.out.println(cas.getBill(new int[] {3,7}, new int[] {10,10}));
        System.out.println(cas.getBill(new int[] {1,2,3,4,5,6,7}, new int[] {1,1,1,1,1,1,1}));
        System.out.println(cas.getBill(new int[] {4}, new int[] {10}));
        System.out.println(cas.getBill(new int[] {7,3}, new int[] {10,10}));
        System.out.println(cas.getBill(new int[] {7,5,3,1,6,4,2}, new int[] {10,10,10,9,9,9,7}));
        System.out.println(cas.getBill(new int[] {2,3,5}, new int[] {5,3,2}));
    }
}

// 模拟
class Cashier {
    private int n;
    private int discount;
    private int[] prices;

    private int curN;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.prices = new int[250];
        for (int i = 0; i < products.length; i++) {
            this.prices[products[i]] = prices[i];
        }
        curN = 0;
    }
    
    public double getBill(int[] product, int[] amount) {
        double sum = 0;
        for (int i = 0; i < product.length; i++) {
            sum += (prices[product[i]] * amount[i]);
        }
        if (++curN == n) {
            sum -= discount * sum / 100;
            curN = 0;
        }

        return sum;
    }
}