import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        String theNumberRead=skener.nextLine();
        String[] splittedTheNumbers=theNumberRead.split(" ");
        List<Integer> theNumbers=new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
               theNumbers.add(Integer.parseInt(splittedTheNumbers[i]));
        }

        String theChisla=skener.nextLine();
        String[] splittedChisla=theChisla.split(" ");
        List<Integer> chisla=new ArrayList<>();
        for (int i = 0; i < splittedChisla.length; i++) {
            chisla.add(Integer.parseInt(splittedChisla[i]));
        }

        List<Integer> removedNumbers=new ArrayList<>();
        int chislaPosition=0;
        while(removedNumbers.size()!=6){
            if(chisla.get(chislaPosition)%theNumbers.get(0)==0){
                removedNumbers.add(chisla.get(chislaPosition));
                theNumbers.remove(0);
                chislaPosition++;
            }else{
                //removedNumbers.add(chisla.get(chislaPosition)+1);
                chisla.add(chisla.get(chislaPosition)+1);
                chislaPosition++;
            }
        }
        String[] res=new String[6];
        for (int i = 0; i <6; i++) {
            res[i]= String.valueOf(removedNumbers.get(i));
        }
        System.out.println(String.join(", ",res));
    }
}