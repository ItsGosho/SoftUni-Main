import java.util.*;

public class T05_Palindromes {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split("[!?., ]");
        String reversed="";
        StringBuilder str=new StringBuilder();
        List<String> result=new ArrayList<>();
        for(String item:line){
            if(!item.equals("")){
                str.append(item);
                str=str.reverse();
                if(str.toString().equals(item)){
                    if(!result.contains(item)){
                        result.add(item);
                    }
                }
                str=new StringBuilder();
            }
        }
        Collections.sort(result);
        System.out.println("["+String.join(", ",result)+"]");
    }
}
