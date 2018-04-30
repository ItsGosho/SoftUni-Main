package T03_StackIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String line = skener.nextLine();
        if(line.length()>=5) {
            line = line.substring(5, line.length());
        }else{
            line="";
        }
        String[] splitted = line.split(", ");
        Stack<String> stack=new Stack<String>(splitted);
        while (true) {
            String line2 = skener.nextLine();
            if (line2.equals("END")) {
                stack.print();
                stack.print();
                break;
            }
            String[] splitted2 = line2.split(" ");
            if(splitted2[0].equals("Pop")){
                stack.pop();
            }else if(splitted2[0].equals("Push")){
                stack.push(splitted2[1]);
            }
        }
    }
}
