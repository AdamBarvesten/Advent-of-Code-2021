import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Dec02 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("dec02/input.txt"));
        
        int forward, depth1, depth2, aim;
        forward = depth1 = depth2 = aim = 0;

        for (String string : input) {
            String[] i = string.split(" ");
            int units = Integer.parseInt(i[1]);

            switch (i[0]) {
                case "forward" -> {
                    forward += units;
                    depth2 += aim * units;
                }
                case "up" -> {
                    depth1 -= units;
                    aim -= units;
                }
                case "down" -> {
                    depth1 += units;
                    aim += units;
                }
            }
        }

        System.out.println("Part one: " + forward*depth1 + " Part two: " + forward*depth2);
    }
}