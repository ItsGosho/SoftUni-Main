import java.util.Arrays;
import java.util.Scanner;

public class T07_FindTheMissingNumber {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int n = Integer.parseInt(skener.nextLine());
        String[] line = skener.nextLine().split(", ");
        int[] arr = new int[n-1];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        bubbleSort(arr);
        int kfd=1;
        for (int i = 0; i < arr.length; i++) {
                if(kfd!=arr[i]){
                    System.out.println(kfd);
                    break;
                }
                kfd++;
            }
        }

    public static void bubbleSort(int[] line) {
            for (int i = 0; i < line.length; i++) {
                boolean smqna=false;
                for (int j = 0; j < line.length-1; j++) {
                    if(line[j]>line[j+1]){
                        int temp=line[j+1];
                        line[j+1]=line[j];
                        line[j]=temp;
                        smqna=true;
                    }
                }
                if(!smqna){
                    break;
                }
            }
        }
}
