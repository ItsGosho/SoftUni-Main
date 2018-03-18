import java.util.ArrayDeque;
import java.util.Scanner;

public class T03_MathPotato {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split(" ");
        int n=Integer.parseInt(skener.nextLine());
        int normal=n;
        ArrayDeque<String> opashka=new ArrayDeque<>();
        for (int i = 0; i < line.length; i++) {
            opashka.add(line[i]);
        }
        int cycle=1;
        boolean isPrime=true;
        do {
            for (int i = 1; i < n; i++)
                opashka.offer(opashka.poll());
            if (isPrime(cycle))
                System.out.println("Prime " + opashka.peek());
            else
                System.out.println("Removed " + opashka.poll());

            cycle++;
        }while(opashka.size()!=1);
        System.out.println("Last is "+opashka.peek());
    }
    static boolean isPrime(int n) {
        int perfect_modulo = 0;
        boolean prime = false;

        for ( int i = 1; i <=  n; i++ ) {
            if ( n % i == 0 ) {
                perfect_modulo += 1;
            }
        }
        if ( perfect_modulo == 2 ) {
            prime = true;
        }

        return prime;
    }
}
