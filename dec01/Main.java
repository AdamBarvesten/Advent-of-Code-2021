import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] input = Files.readAllLines(Paths.get("dec01/input.txt")).stream().mapToInt(Integer::parseInt).toArray();
        
        part1(input);
        part2(input);
    }
    
    private static void part1(int[] in){
        int counter = 0;
        for(int i=0 ; i<in.length-1 ; i++){
            if(in[i+1] > in[i]){
                counter++;
            }
        }
        System.out.println("Part one: " + counter);
    }

    private static void part2(int[] in){
        int counter = 0;
        for(int i=0; i<in.length-3; i++){
                if(in[i+1]+in[i+2]+in[i+3] > in[i]+in[i+1]+in[i+2]){
                    counter++;
                }
        }
        System.out.println("Part two: " + counter);
    }
}