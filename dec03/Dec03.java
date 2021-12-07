import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Dec03 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("dec03/input.txt"));

        int[] gamma2 = new int[5]; 

        int ones = 0;  
        int zeros = 0;
        String gamma = "";
        String epsilon = "";

        for (int i = 0; i < lines.get(0).length(); i++) {
            ones = 0;
            for (String l : lines) {
                ones += l.charAt(i) == '1' ? 1 : 0;
            }
            zeros = lines.size() - ones;
            gamma += ones > zeros ? "1" : "0";
            epsilon += ones > zeros ? "0" : "1";
        }
        System.out.println("gamma: " + gamma);
        System.out.println("eps: " + epsilon);        

        printAnswer(gamma2);
        printAnswerBinary(gamma2);
        
        char[] g = gamma.toCharArray();

        /*
        List<String> oxygen = lines;
        List<String> co2 = lines;
        List<String> temp = new ArrayList<>();
        int index = 0;

        while(oxygen.size() > 1){
            for(String o : oxygen){
                if(o.charAt(index)== '1'){temp.add(o);}
            }
            oxygen = temp;
        }
        */

        
        ArrayList<String> oxygen = new ArrayList<String>(lines);
		ArrayList<String> co2 = new ArrayList<String>(lines);

        List<String> list;

        int index = 0;
        while(oxygen.size()>1){
            for (int i = oxygen.size()-1; i >= 0; i--) {
                if(oxygen.get(i).charAt(i) != gamma.charAt(i)){oxygen.remove(o);}
                
            }
        }

        for(int i = list.size()-1; i >= 0; --i) {
            if(list.get(i).contains("bad")){
                list.remove(i);
            }
        }


        System.out.println("TEMP: " + oxygen.size());
        System.out.println("VAL : " + oxygen.get(0));



        System.out.println(" ");
        int pb = 0;
        int pBest = 0;
        String sBest = "";
        int pw = 0;
        int pWorst= 0;
        String sWorst = "";


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