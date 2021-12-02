import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Dec02 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("dec02/input.txt"));

        int forward = 0;
        int depth = 0;
        int aim = 0;

        for (String l : lines) {
            String[] s = l.split(" ");

            switch (s[0]) {
                case "forward" -> {
                    forward += Integer.parseInt(s[1]);
                    depth += aim * Integer.parseInt(s[1]);
                }
                case "up" -> {
                    depth -= Integer.parseInt(s[1]);
                    aim -= Integer.parseInt(s[1]);
                }
                case "down" -> {
                    depth += Integer.parseInt(s[1]);
                    aim += Integer.parseInt(s[1]);
                }
            }
        }
        System.out.println("forward: " + forward + "  depth: " + depth + " answer: " + forward*depth);
    }

}