import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Dec05 {
    static final int DIAGRAM_SIZE = 1000;
    static int[][] diagram = new int[DIAGRAM_SIZE][DIAGRAM_SIZE];

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dec05/input.txt");
        Scanner scanner = new Scanner(file);


        while (scanner.hasNextLine()){
            int[] input = Stream.of(scanner.nextLine().replace(" -> ",",").split(",")).mapToInt(Integer::parseInt).toArray();
            updateDiagram(input);
        }
        scanner.close();

        printDiagram();
        System.out.println("Hello: "+        calulateOverlaps());
    }

    private static int calulateOverlaps() {
        int sum = 0;
        for (int i = 0; i < DIAGRAM_SIZE; i++) {
            for (int j = 0; j <DIAGRAM_SIZE; j++) {
                if(diagram[i][j]>1){sum++;}
            }
        }
        return sum;
    }

    private static void updateDiagram(int[] input) {
        if(input[0] == input[2] || input[1] == input[3]){
            if(input[0] == input[2]){
                int min = min(input[1],input[3]);
                int max = max(input[1],input[3]);
                for (int i = min; i <= max; i++) {
                    diagram[i][input[0]] += 1;
                }
            }else if(input[1] == input[3]){
                int min = min(input[0],input[2]);
                int max = max(input[0],input[2]);
                for (int i = min; i <= max; i++) {
                    diagram[input[1]][i] += 1;
                }
            }
        }else{
            int[] start = (input[0] < input[2]) ? new int[]{input[0], input[1]} : new int[]{input[2], input[3]};
            int[] end = (input[0] > input[2]) ? new int[]{input[0], input[1]} : new int[]{input[2], input[3]};

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

    private static void printDiagram(){
        for (int i = 0; i < DIAGRAM_SIZE; i++) {
            for (int j = 0; j < DIAGRAM_SIZE; j++) {
                System.out.print(diagram[i][j]);
            }
            System.out.println(" ");
        }
    }

}
