import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Dec05 {
    static final int SIZE = 1000;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dec05/input.txt");
        Scanner scanner = new Scanner(file);

        int[][] diagramStraight = new int[SIZE][SIZE];
        int[][] diagramDiagonals = new int[SIZE][SIZE];

        while (scanner.hasNextLine()){
            int[] input = Stream.of(scanner.nextLine().replace(" -> ",",").split(",")).mapToInt(Integer::parseInt).toArray();
            updateDiagram(input, diagramStraight, false);
            updateDiagram(input, diagramDiagonals, true);
        }
        scanner.close();

        System.out.println("Part One: " + calulateOverlaps(diagramStraight) + "\n" + "Part Two: " + calulateOverlaps(diagramDiagonals));
    }

    private static int calulateOverlaps(int[][] diagram) {
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <SIZE; j++) {
                if(diagram[i][j]>1){sum++;}
            }
        }
        return sum;
    }

    private static void updateDiagram(int[] input, int[][] diagram, boolean isDiagonal) {
        int x1, y1, x2, y2;
        x1 = input[0];
        y1 = input[1];
        x2 = input[2];
        y2 = input[3];

        if(x1 == x2 || y1 == y2){
            if(x1 == x2){
                int min = min(y1,y2);
                int max = max(y1,y2);
                for (int i = min; i <= max; i++) {
                    diagram[i][x1] += 1;
                }
            }else if(y1 == y2){
                int min = min(x1,x2);
                int max = max(x1,x2);
                for (int i = min; i <= max; i++) {
                    diagram[y1][i] += 1;
                }
            }
        }else if(isDiagonal){
            int[] start = (x1 < x2) ? new int[]{x1, y1} : new int[]{x2, y2};
            int[] end = (x1 > x2) ? new int[]{x1, y1} : new int[]{x2, y2};

            if(start[1] < end[1]){
                for (int i = start[0]; i <= end[0] ; i++) {
                    diagram[start[1]][i] += 1;
                    start[1] += 1;
                }
            }else{
                for (int i = start[0]; i <= end[0] ; i++) {
                    diagram[start[1]][i] += 1;
                    start[1] -= 1;
                }
            }
        }
    }
}
