import java.util.*;

public class T02_MaximumElement {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int n=Integer.parseInt(skener.nextLine());
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int z=0;
        while(n>z){
            String[] line=skener.nextLine().split(" ");
            if(line[0].contains("1")){
                stack.push(Integer.parseInt(line[1]));
            }else if(line[0].contains("2")){
                    stack.pop();
            }else if(line[0].contains("3")){
                ArrayList<Integer> res=new ArrayList<>();
                ArrayDeque<Integer> stack2=stack.clone();
                for (int i = 0; i < stack.size(); i++) {
                    res.add(stack2.pop());
                }
                res.sort(Integer::compareTo);
                System.out.println(res.get(res.size()-1));
                res.clear();
            }
            z++;
        }
    }
}
