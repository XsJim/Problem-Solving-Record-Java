import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AnimalShelf animalShelf = new AnimalShelf();
        animalShelf.enqueue(new int[] {0, 0});
        animalShelf.enqueue(new int[] {1, 1});
        // System.out.println(Arrays.toString(animalShelf.dequeueCat()));
        // System.out.println(Arrays.toString(animalShelf.dequeueDog()));
        System.out.println(Arrays.toString(animalShelf.dequeueAny()));

    }
}

class AnimalShelf {
    private ArrayDeque<int[]> aqCat;
    private ArrayDeque<int[]> aqDog;

    public AnimalShelf() {
        aqCat = new ArrayDeque<>();
        aqDog = new ArrayDeque<>();
    }
    
    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            aqCat.add(animal);
        } else aqDog.add(animal);
    }
    
    public int[] dequeueAny() {
        if (aqCat.isEmpty() && aqDog.isEmpty()) return new int[] {-1, -1};
        if (aqCat.isEmpty()) return aqDog.poll();
        if (aqDog.isEmpty()) return aqCat.poll();
        return aqCat.peek()[0] > aqDog.peek()[0] ? aqDog.poll() : aqCat.poll();
    }
    
    public int[] dequeueDog() {
        if (aqDog.isEmpty()) return new int[] {-1, -1};
        return aqDog.poll();
    }
    
    public int[] dequeueCat() {
        if (aqCat.isEmpty()) return new int[] {-1, -1};
        return aqCat.poll();
    }
}