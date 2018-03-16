import java.util.Arrays;
import java.util.Scanner;

public class T01_Sorting {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] vhod=skener.nextLine().split(" ");
        int[] arr=new int[vhod.length];
        for (int i = 0; i < vhod.length; i++) {
            arr[i]=Integer.parseInt(vhod[i]);
        }
       //bubbleSort(arr);
       //selectionSort(arr);
    }
    //Selection 100/100
    public static void selectionSort(int[] line) {
        for (int i = 0; i < line.length; i++) {
            boolean change=false;
            int min = line[i];
            int indexSmqna = 0;
            for (int j = i; j < line.length; j++) {
                if (line[j] < min) {
                    indexSmqna = j;
                    min = line[j];
                    change=true;
                }
            }
            if(change) {
                line[indexSmqna] = line[i];
                line[i] = min;
            }
        }
        for (int i = 0; i < line.length; i++) {
            System.out.print(line[i] + " ");
        }
    }
    //Bubble 85/100
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

        for (int i = 0; i < line.length; i++) {
            System.out.print(line[i] + " ");
        }
    }
}