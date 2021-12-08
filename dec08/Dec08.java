import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Dec08 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("dec04/input.txt"));
        HashMap<String[],String[]> entries = new HashMap<>();
        String[] entry;

        while(scanner.hasNextLine()){
            entry = scanner.nextLine().split(" | ");
            entries.put(entry[0].split(" "), entry[1].split(" "));
        }


        for(String e : entries.values()){

        }

    }
}
