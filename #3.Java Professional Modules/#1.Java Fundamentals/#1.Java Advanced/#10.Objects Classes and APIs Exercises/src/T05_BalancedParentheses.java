import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class T05_BalancedParentheses {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
       String line=skener.nextLine();
        ArrayDeque<String> queue=new ArrayDeque<>();
        char[] words=line.toCharArray();
        boolean yes=true;
        boolean shit100=true;
        for (int i = 0; i < line.length(); i++) {
            char word=words[i];
            if(word=='{' || word=='[' || word=='('){
               queue.push(String.valueOf(word));
            }else if(word=='}' || word==']' || word==')'){
                try {
                    String firstChar = queue.pop();
                    String secondChar = line.substring(line.indexOf(firstChar) + 1, i + 1);
                    String parsed = line.substring(line.indexOf(firstChar), i + 1);
                    char[] test = parsed.toCharArray();
                    char toEndWith = ' ';
                    if (test[0] == '(') {
                        toEndWith = ')';
                    } else if (test[0] == '{') {
                        toEndWith = '}';
                    } else if (test[0] == '[') {
                        toEndWith = ']';
                    }
                    if (test[test.length - 1] == toEndWith) {
                    } else {
                        yes = false;
                    }
                }catch(NoSuchElementException e){
                    yes=false;
                }
            }
        }
        if(yes){
            System.out.println("YES");
        }
        if(!yes){
            System.out.println("NO");
        }
    }
}
