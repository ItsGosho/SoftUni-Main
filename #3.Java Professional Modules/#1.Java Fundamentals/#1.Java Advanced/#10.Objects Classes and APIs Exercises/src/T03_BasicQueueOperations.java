import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T03_BasicQueueOperations {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line = skener.nextLine().split(" ");
        String[] nums = skener.nextLine().split(" ");
        int toPush = Integer.parseInt(line[0]);
        int toPop = Integer.parseInt(line[1]);
        int toCheck = Integer.parseInt(line[2]);
        int min=Math.max(nums.length,toPush);
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for (int i = 0; i < min; i++) {
            stack.add(Integer.parseInt(nums[i]));
        }
        for (int i = 0; i < toPop; i++) {
            stack.poll();
        }
        if(stack.contains(toCheck)){
            System.out.println("true");
        }else{
            ArrayList<Integer> res=new ArrayList<>();
            ArrayDeque<Integer> stack2=stack.clone();
            for (int i = 0; i < stack.size(); i++) {
                res.add(stack2.pop());
            }
            res.sort(Integer::compareTo);
            System.out.println(res.get(0));
        }
    }
}
