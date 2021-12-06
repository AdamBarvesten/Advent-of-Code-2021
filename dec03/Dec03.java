import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Dec03 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("dec03/input.txt"));

        int[] gamma = new int[5];

        for (String l : lines) {
            for(int i=0; i < l.length() ; i++){
                switch (l.charAt(i)){
                    case '0' : gamma[i] -=1;
                    break;
                    case '1' : gamma[i] +=1;
                }
            }
        }


        printAnswer(gamma);
        printAnswerBinary(gamma);
        



        System.out.println(" ");
        int pb = 0;
        int pBest = 0;
        String sBest = "";
        int pw = 0;
        int pWorst= 0;
        String sWorst = "";


        for(String l : lines){
            pb = 0;
            for(int i = 0; i < gamma.length ; i++){
                if(gamma[i] == Character.getNumericValue(l.charAt(i))){
                    pb++;
                    if(pb > pBest){
                        pBest = pb;
                        sBest = l;
                    }
                }else{
                    break;
                }
            }
        }

        for(String l : lines){
            pw=0;
            for(int i = 0; i < gamma.length ; i++){
                if(gamma[i] != Character.getNumericValue(l.charAt(i))){
                    pw++;
                    if(pw > pWorst){
                        pWorst = pw;
                        sWorst = l;
                    }
                }else{
                    break;
                }
            }
        }

        System.out.println("best: " + Integer.parseInt(sBest, 2) + " " + sBest);
        System.out.println("worst: " + Integer.parseInt(sWorst, 2) + " " + sWorst);
        System.out.println(3531 * 567);




        List<String> lines3 = lines;

        for(int i =0 ; i < gamma.length ; i++){
            for(int j=0; j < lines3.size() ; j++){
                if(gamma[i] == 1 && lines3.get(j).charAt(i) == '1' || gamma[i] == 0 && lines3.get(j).charAt(i) == '0'){
                    lines3.remove(lines3.get(j));
                    if(lines3.size() == 1){break;}
                }
            }
            if(lines3.size() == 1){break;}
        }

        for(String l : lines3){
            System.out.println("second: " + Integer.parseInt(l, 2) + " " + l);
        }



        List<String> lines2 = lines;

        for(int i =0 ; i < gamma.length ; i++){
            for(int j=0; j < lines2.size() ; j++){
                if(gamma[i] != Character.getNumericValue(lines2.get(j).charAt(i))){
                    lines2.remove(lines2.get(j));

                    if(lines2.size() == 1){break;}
                }
            }
            if(lines2.size() == 1){break;}
        }

        for(String l : lines2){
            System.out.println("first: " + Integer.parseInt(l, 2)+ " " + l + 3557);
        }

        byte five = 0b101;
        System.out.println(five);
        System.out.println(~five);
        System.out.println(0b010);


        String inverted = "110011";

        int i = Integer.parseInt(inverted, 16);
        i = ~i;
        inverted = inverted.substring(2);
        System.out.println(inverted);
    }

    private static void printAnswerBinary(int[] answer) {
        
        for(int i = 0; i < answer.length ; i++){
            if (answer[i] > 0){
                answer[i] = 1;
                System.out.print("1");
            }else{
                answer[i] = 0;
                System.out.print("0");
            }
        }
    }

    private static void printAnswer(int[] answer) {
        for (int a : answer) {
            System.out.print("");
            System.out.print(a + " ");
        }
        System.out.println(" "  );
        System.out.println("" );
    }

}