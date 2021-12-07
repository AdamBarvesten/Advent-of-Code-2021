import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dec07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dec07/input.txt");
        Scanner scanner = new Scanner(file);

        int [] pos = Stream.of(scanner.next().split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(pos);
        double median = (pos.length % 2 == 0) ? ((double)pos[pos.length/2] + (double)pos[pos.length/2 - 1])/2 : (double)pos[pos.length/2];

        double mean = 0;


        for (int po : pos) { mean += po;}
        mean = mean / pos.length;
        mean = Math.round(Arrays.stream(pos).average().orElse(Double.NaN));
        System.out.println(mean);

        int sum = 0;
        for(int p : pos){
            double dist = Math.abs(p-mean);
            sum +=  dist * ( dist + 1 ) / 2;
        }


        System.out.println("fuel: "+calculateFuel(pos, median));
        System.out.println("fuel2: " + sum);

    }

    private static int calculateFuel(int[] pos, double median) {
        int sum = 0;
        for(int p : pos){
            sum += Math.abs(p - median);
        }
        return sum;
    }

    //too high 101268141

}
