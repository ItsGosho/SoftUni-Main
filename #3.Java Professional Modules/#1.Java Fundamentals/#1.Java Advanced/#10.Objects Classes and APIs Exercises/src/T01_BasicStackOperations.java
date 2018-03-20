import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T01_BasicStackOperations {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line = skener.nextLine().split(" ");
        String[] nums = skener.nextLine().split(" ");
        int toPush = Integer.parseInt(line[0]);
        int toPop = Integer.parseInt(line[1]);
        int toCheck = Integer.parseInt(line[2]);
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int min=Math.max(nums.length,toPush);
        for (int i = 0; i < min; i++) {
            stack.push(Integer.parseInt(nums[i]));
        }
        for (int i = 0; i < toPop; i++) {
            stack.pop();
        }
        if(stack.contains(toCheck)){
            System.out.println("true");
        }else{
            Arrays.sort(new ArrayDeque[]{stack});
            System.out.println(stack.peek());
        }
    }
}
