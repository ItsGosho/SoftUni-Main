import java.util.Scanner;

public class T01_ReverseArray {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line = skener.nextLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        reverse(arr,0);
    }
    public static int[] reverse(int[] arr,int i){
        if(i==arr.length/2){
            return print(arr);
        }
        // 1 2 3 4 5
        int memory=arr[arr.length-1-i];
        arr[arr.length-1-i]=arr[i];
        arr[i]=memory;
        return reverse(arr,i+=1);
    }
    public static int[] print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        return arr;
    }
}
