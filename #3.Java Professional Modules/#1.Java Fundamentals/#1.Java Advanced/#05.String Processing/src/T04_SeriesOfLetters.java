import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T04_SeriesOfLetters {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String line = skener.nextLine();
        char[] words = line.toCharArray();
        StringBuilder result= new StringBuilder();
        result.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            char last=words[i-1];
            if(words[i]!=last){
                result.append(words[i]);
            }
        }
        System.out.println(result);
    }
}
