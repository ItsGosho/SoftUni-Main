import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class T11_PredicateParty {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line = skener.nextLine().split(" ");
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            arr.add(line[i]);
        }
        while(true){
            String vhod=skener.nextLine();
            if(vhod.equals("Party!")){
                if(arr.size()!=0) {
                    for (int i = 0; i < arr.size(); i++) {
                        if(i!=arr.size()-1){
                            System.out.print(arr.get(i)+", ");
                        }else{
                            System.out.print(arr.get(i)+" ");
                        }
                    }
                    System.out.print("are going to the party!");
                }else{
                    System.out.println("Nobody is going to the party!");
                }
                 break;
            }
            work(arr,vhod);
        }
    }
    public static void work(ArrayList<String> arr,String vhod){
        String[] input=vhod.split(" ");
        String removeOrDouble=input[0];
        String command=input[1];
        if(removeOrDouble.equals("Remove")){
            //Remove->Length
            if(command.equals("Length")){
                int commandInput=Integer.parseInt(input[2]);
                Predicate<String> removeLength=x->x.length()==commandInput;
                for (int i = 0; i < arr.size(); i++) {
                    if(removeLength.test(arr.get(i))){
                        arr.remove(i);
                    }
                }
            }else if(command.equals("StartsWith")){
                String commandInput=input[2];
                Predicate<String> removeStartsWith=x->{
                    char[] wordInput=x.toCharArray();
                    char[] wordCheck=commandInput.toCharArray();
                    boolean raboti=true;
                    for (int i = 0; i < wordCheck.length; i++) {
                        if(wordInput[i]!=wordCheck[i]){
                            raboti=false;
                        }
                    }
                    return raboti;
                };
                for (int i = 0; i < arr.size(); i++) {
                    if(removeStartsWith.test(arr.get(i))){
                        arr.remove(i);
                    }
                }

            }else if(command.equals("EndsWith")){
                String commandInput=input[2];
                Predicate<String> removeEndsWith=x->{
                    char[] wordInput=x.toCharArray();
                    char[] wordCheck=commandInput.toCharArray();
                    boolean raboti=true;
                    int mejdinnoI=0;
                    for (int i = wordCheck.length;i > 0; i--) {
                        if(wordInput[wordInput.length-1-mejdinnoI]!=wordCheck[wordCheck.length-1-mejdinnoI]){
                            raboti=false;
                        }
                        mejdinnoI++;
                    }
                    return raboti;
                };
                for (int i = 0; i < arr.size(); i++) {
                    if(removeEndsWith.test(arr.get(i))){
                        arr.remove(i);
                    }
                }
            }
        }else if(removeOrDouble.equals("Double")){
            ArrayList<String> kopie=new ArrayList<>();
            if(command.equals("Length")){
                int commandInput=Integer.parseInt(input[2]);
                Predicate<String> removeLength=x->x.length()==commandInput;
                for (int i = 0; i < arr.size(); i++) {
                    if(removeLength.test(arr.get(i))){
                        kopie.add(arr.get(i));
                        kopie.add(arr.get(i));
                    }else{
                        kopie.add(arr.get(i));
                    }
                }
            }else if(command.equals("StartsWith")){
                String commandInput=input[2];
                Predicate<String> removeStartsWith=x->{
                    char[] wordInput=x.toCharArray();
                    char[] wordCheck=commandInput.toCharArray();
                    boolean raboti=true;
                    for (int i = 0; i < wordCheck.length; i++) {
                        if(wordInput[i]!=wordCheck[i]){
                            raboti=false;
                        }
                    }
                    return raboti;
                };
                for (int i = 0; i < arr.size(); i++) {
                    if(removeStartsWith.test(arr.get(i))){
                        kopie.add(arr.get(i));
                        kopie.add(arr.get(i));
                    }else{
                        kopie.add(arr.get(i));
                    }
                }
            }else if(command.equals("EndsWith")){
                String commandInput=input[2];
                Predicate<String> removeEndsWith=x->{
                    char[] wordInput=x.toCharArray();
                    char[] wordCheck=commandInput.toCharArray();
                    boolean raboti=true;
                    int mejdinnoI=0;
                    for (int i = wordCheck.length;i > 0; i--) {
                        if(wordInput[wordInput.length-1-mejdinnoI]!=wordCheck[wordCheck.length-1-mejdinnoI]){
                            raboti=false;
                        }
                        mejdinnoI++;
                    }
                    return raboti;
                };
                for (int i = 0; i < arr.size(); i++) {
                    if(removeEndsWith.test(arr.get(i))){
                        kopie.add(arr.get(i));
                        kopie.add(arr.get(i));
                    }else{
                        kopie.add(arr.get(i));
                    }
                }
            }
            arr.clear();
            arr.addAll(kopie);
        }
    }
}
