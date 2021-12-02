import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Dec02 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("dec02/input.txt"));
        
        int forward, depth1, depth2, aim;
        forward = depth1 = depth2 = aim = 0;

        for (String l : lines) {
            String[] s = l.split(" ");
            int value = Integer.parseInt(s[1]);

            switch (s[0]) {
                case "forward" -> {
                    forward += value;
                    depth2 += aim * value;
                }
                case "up" -> {
                    depth1 -= value;
                    aim -= value;
                }
                case "down" -> {
                    depth1 += value;
                    aim += value;
                }
            }
        }

        System.out.println("Part one: " + forward*depth1 + " Part two: " + forward*depth2);
    }
}