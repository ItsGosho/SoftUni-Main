import java.util.Scanner;

public class T03_RecursiveArraySum {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] vhod=skener.nextLine().split(" ");
        int[] arr=new int[vhod.length];
        for (int i = 0; i < vhod.length; i++) {
            arr[i]=Integer.parseInt(vhod[i]);
        }
        System.out.println(recusrsiveArraySum(arr,0,0));
    }
    public static int recusrsiveArraySum(int[] vhod,int sum,int i){
         if(i==vhod.length-1){
             return sum += vhod[vhod.length-1];
         }
         return recusrsiveArraySum(vhod,sum+=vhod[i],i+=1);
    }
}
