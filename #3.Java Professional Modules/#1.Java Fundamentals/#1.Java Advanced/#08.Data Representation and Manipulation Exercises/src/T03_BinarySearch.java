import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class T03_ImplementBinarySearchUsingRecursion {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line = skener.nextLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        int number = Integer.parseInt(skener.nextLine());
        System.out.println(vhodna(arr,number));
    }

    public static int vhodna(int[] line, int num) {
        Arrays.sort(line);
        int middle = (line.length - 1) / 2;
        int start = 0;
        int end = 0;
        if (num >= line[middle]) {
            start = middle ;
            end = line.length-1;
        } else if (num <= line[middle]) {
            start = 0;
            end = middle;
        }
        return binarySearch(line, num, start, end,0,0);
    }

    public static int binarySearch(int[] line, int num, int start, int end,int nowNumber
    ,int index) {
        if(line[start]==num){
            return start;
        }
        if(start==end){
            return -1;
        }
        return binarySearch(line, num, start+=1, end,0,0);
    }
}
