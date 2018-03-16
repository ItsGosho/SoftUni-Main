import java.util.Arrays;
import java.util.Scanner;

public class T02_Searching {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] vhod=skener.nextLine().split(" ");
        int[] arr=new int[vhod.length];
        for (int i = 0; i < vhod.length; i++) {
            arr[i]=Integer.parseInt(vhod[i]);
        }
        int num=Integer.parseInt(skener.nextLine());
        binarySearch(arr,num);
    }
    public static void linearSearch(int[] line,int num){
        for (int i = 0; i < line.length; i++) {
            if(line[i]==num){
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }
    public static void binarySearch(int[] line,int num){
        Arrays.sort(line);
        int middle=(line.length-1)/2;
        int start=0;
        int end=0;
        if (num>=line[middle]) {
            start=middle+1;
            end=line.length;
        }else if(num<=line[middle]){
            start=0;
            end=middle;
        }
        for (int i = start; i < end; i++) {
            if(num==line[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }
}
