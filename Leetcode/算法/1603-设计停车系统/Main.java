public class Main {
    public static void main(String[] args) {
        ParkingSystem p = new ParkingSystem(1,1,0);
        System.out.println(p.addCar(1));
        System.out.println(p.addCar(2));
        System.out.println(p.addCar(3));
        System.out.println(p.addCar(1));
    }
}

// 模拟即可
class ParkingSystem {
    private int[] count;

    public ParkingSystem(int big, int medium, int small) {
        count = new int[4];
        count[1] = big;
        count[2] = medium;
        count[3] = small;
    }
    
    public boolean addCar(int carType) {
        if (count[carType] != 0) {
            count[carType]--;
            return true;
        }
        return false;
    }
}