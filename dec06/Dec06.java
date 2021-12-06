import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Dec06 {
    public static void main(String[] args) throws IOException {
        File file = new File("dec06/input.txt");
        Scanner scanner = new Scanner(file);

        List<Integer> numbers = Arrays.stream(scanner.next().split(",")).map(Integer::valueOf).collect(Collectors.toList());
        scanner.close();
        
        System.out.println("Day 80: " + solve(80, numbers));
        System.out.println("Day 256: " + solve(256, numbers));

    }

    private static long solve(int day, List<Integer> numbers){
        long[] fishes = new long[9];

        for (int i : numbers) {
            fishes[i]++;
        }

        for (int i = 1 ; i <= day; i++) {
            long spawningFish = fishes[0];
            for (int j = 0 ; j < fishes.length-1; j++) {
                fishes[j] = fishes[j+1];
            }
            fishes[6] += spawningFish;
            fishes[8] = spawningFish;
        }
        return Arrays.stream(fishes).sum();
    }
}
