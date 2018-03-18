import java.util.ArrayDeque;
import java.util.Scanner;

public class T01_MatchingBrackets {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String line=skener.nextLine();
        char[] charred=line.toCharArray();
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {
            char word=charred[i];
            if(word=='('){
                stack.push(i);
            }else if(word==')'){
                System.out.println(line.substring(stack.peek(),i+1));
                stack.poll();
            }
        }
    }
}
