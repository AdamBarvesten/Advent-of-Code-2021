import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Dec08 {
    static final int ONE = 2;
    static final int FOUR = 4;
    static final int SEVEN = 3;
    static final int EIGHT = 7;
    static final int ZERO_SIX_NINE = 6;
    static final int TWO_THREE_FIVE = 5;

    static final int A = 0;
    static final int B = 1;
    static final int C = 2;
    static final int D = 3;
    static final int E = 4;
    static final int F = 5;
    static final int G = 6;


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("dec08/input.txt"));
        HashMap<String[],String[]> entries = new HashMap<>();
        String[] entry;

        while(scanner.hasNextLine()){
            entry = scanner.nextLine().split(" \\| ");
            entries.put(entry[0].split(" "), entry[1].split(" "));
        }

        int sum = 0;
        for(String[] value : entries.values()){
            for(String digit : value){
                int len = digit.length();
                boolean isEasyDigit = (len == 2 || len == 3 || len == 4 || len == 7);
                if(isEasyDigit){ sum++;};
            }
        }
        System.out.println(sum);


        String[] ABCDEF = new String[7];

        for (int i = 0; i < ABCDEF.length; i++) {
            ABCDEF[i] = "abcdef";
        }

        for(String[] key : entries.keySet()){
            for(String digit : key){
                ABCDEF = update(ABCDEF, digit);
            }
        }
    }

    /*
             aaaa   
            b    c 
            b    c 
             dddd   
            e    f 
            e    f 
             gggg   
    */

    private static final char[] ON = {'C', 'F'};

    private String[] update(String[] ABCDEF, String digit){
        switch(digit.length()){
            case ONE -> {
                for (int i = 0 ; i < ABCDEF.length ; i++){}

                ABCDEF[C] = (ABCDEF.length > 2) ? digit : ABCDEF[C];
                ABCDEF[F] = (ABCDEF.length > 2) ? digit : ABCDEF[F];

                ABCDEF[A] = ABCDEF[A].replace(digit.charAt(0), "");
                ABCDEF[A] = ABCDEF[A].replace(digit.charAt(1), "");
                ABCDEF[B] = ABCDEF[B].replace(digit.charAt(0), "");

            }
            case SEVEN-> {
                ABCDEF[A] = (ABCDEF.length > 4) ? digit : ABCDEF[C];
                ABCDEF[C] = (ABCDEF.length > 4) ? digit : ABCDEF[F];
                ABCDEF[F] = (ABCDEF.length > 4) ? digit : ABCDEF[F];
                updateSegments(ABCDEF, digit);
            }
            case FOUR-> {
                ABCDEF[B] = (ABCDEF.length > 4) ? digit : ABCDEF[C];
                ABCDEF[C] = (ABCDEF.length > 4) ? digit : ABCDEF[F];
                ABCDEF[D] = (ABCDEF.length > 4) ? digit : ABCDEF[C];
                ABCDEF[F] = (ABCDEF.length > 4) ? digit : ABCDEF[F];
                updateSegments(ABCDEF, digit);
            }
        }

        return null;

    }


        /*
             aaaa   
            b    c 
            b    c 
             dddd   
            e    f 
            e    f 
             gggg   
        */
    private void updateSegments(String[] ABCDEF, String digit, int inputDigit) {
        for (int i = 0; i < ABCDEF.length; i++) {
            switch(digit.length()){
                case ONE -> {
                    ABCDEF[A] = ABCDEF[A].replace("target", replacement)
                    ABCDEF[F] = (ABCDEF.length > 2) ? digit : ABCDEF[F];
                }
                case SEVEN-> {
                    ABCDEF[A] = (ABCDEF.length > 4) ? digit : ABCDEF[C];
                    ABCDEF[C] = (ABCDEF.length > 4) ? digit : ABCDEF[F];
                    ABCDEF[F] = (ABCDEF.length > 4) ? digit : ABCDEF[F];
                }
                case FOUR-> {
                    ABCDEF[B] = (ABCDEF.length > 4) ? digit : ABCDEF[C];
                    ABCDEF[C] = (ABCDEF.length > 4) ? digit : ABCDEF[F];
                    ABCDEF[D] = (ABCDEF.length > 4) ? digit : ABCDEF[C];
                    ABCDEF[F] = (ABCDEF.length > 4) ? digit : ABCDEF[F];
                }
            }
            
        }
    }
}
