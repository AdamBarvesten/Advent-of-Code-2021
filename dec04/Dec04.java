import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Dec04 {

    static List<int[][]> boards = new ArrayList<>();
    static int winScore = 0;
    static int looseScore = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("dec04/input.txt"));
        int[] numbers = Stream.of(scanner.next().split(",")).mapToInt(Integer::parseInt).toArray();
        int[][] board = new int[5][5];

        scanner.nextLine();
        while(scanner.hasNextInt()){
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5 ; j++){
                    board[i][j] = scanner.nextInt();
                }
            }
            boards.add(board);
            board = new int[5][5];
        }
        scanner.close();

        int index = 0;
        while(winScore==0 || looseScore==0){
            drawNumber(numbers[index]);
            index++;
        }

        System.out.println("Part One: " + winScore);
        System.out.println("Part Two: " + looseScore);
    }

    private static int calculateBoard(int[][] board) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(board[i][j]>0){sum += board[i][j];}
            }
        }
        return sum;
    }

    private static void drawNumber(int number){ 
        for (Iterator<int[][]> it = boards.iterator() ; it.hasNext();){
            int[][] board = it.next();
            for (int i = 0; i < 5 ; i++){
                for (int j = 0; j < 5; j++) {
                    if(board[i][j] == number){
                        board[i][j] = -1;
                        if(checkBingo(board)){
                            if(boards.size() == 1) { looseScore = number * calculateBoard(board);}
                            if(winScore == 0){ winScore = number * calculateBoard(board);}
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    private static boolean checkBingo(int[][] board) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(board[i][j] == -1){row++;}
                if(board[j][i] == -1){col++;}
            }
            if(row == 5) {return true;}
            if(col == 5) {return true;}
            row = 0;
            col = 0;
        }
        return false;
    }
} 