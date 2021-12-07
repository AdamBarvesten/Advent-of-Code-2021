import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Dec07 {
    public static void main(String[] args) throws IOException {
        int [] crabs = Arrays.stream(Files.readString(Path.of("dec07/input.txt")).trim().split(",")).mapToInt(Integer::parseInt).sorted().toArray();
        double median = (crabs.length % 2 == 0) ? ((double)crabs[crabs.length/2] + (double)crabs[crabs.length/2 - 1])/2 : (double)crabs[crabs.length/2];
        double mean = Math.floor(Arrays.stream(crabs).average().orElse(Double.NaN));

        int fuel1 = 0;
        int fuel2 = 0;
        for(int c : crabs){
            fuel1 += Math.abs(c - median);
            fuel2 += Math.abs(c-mean) * ( Math.abs(c-mean) + 1 ) / 2;
        }

        System.out.println("Part One: " + fuel1 + "\n" + "Part Two: " + fuel2);
    }
}
