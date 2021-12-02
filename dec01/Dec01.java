import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Dec01 {
    public static void main(String[] args) throws IOException {
        int[] input = Files.readAllLines(Paths.get("dec01/input.txt")).stream().mapToInt(Integer::parseInt).toArray();
        solve(input,1);
        solve(input,3);
    }
    
    private static void solve(int[] in, int window){
        int counter = 0;
        for(int i=0 ; i<in.length-window ; i++){
            if(in[i+window] > in[i]){
                counter++;
            }
        }
        System.out.println("Solution with window " + window + ": " + counter);
    }
}