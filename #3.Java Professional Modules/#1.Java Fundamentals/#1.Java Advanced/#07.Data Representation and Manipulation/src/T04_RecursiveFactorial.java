import java.util.Scanner;

public class T04_RecursiveFactorial {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int chislo=Integer.parseInt(skener.nextLine());
        System.out.println(factorialSumator(chislo,1,1));
    }
    public static int factorialSumator(int number,int chislo,int counter){
        if(number<counter){
            return chislo;
        }
        return factorialSumator(number,chislo*counter,counter+=1);
    }
}
