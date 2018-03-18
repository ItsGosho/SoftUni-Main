import java.util.ArrayDeque;
import java.util.Scanner;

public class T02_HotPotato {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split(" ");
        int n=Integer.parseInt(skener.nextLine());
        ArrayDeque<String> opashka=new ArrayDeque<>();
        for (int i = 0; i < line.length; i++) {
            opashka.add(line[i]);
        }
        int i=1;
        do {
            if(i==n){
                i=0;
                String removed=opashka.peekFirst();
                opashka.remove();
                System.out.println("Removed "+removed);
            }else{
                String removed=opashka.peekFirst();
                opashka.remove();
                opashka.add(removed);
            }
            i++;
        }while(opashka.size()!=1);
        System.out.println("Last is "+opashka.peek());
    }
}
