import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        int problemsCount=Integer.parseInt(skener.nextLine());
        int candidatesCount=Integer.parseInt(skener.nextLine());

        ArrayDeque<String> problems=new ArrayDeque<>();
        ArrayDeque<String> candidates=new ArrayDeque<>();

        for (int i = 0; i < problemsCount; i++) {
               problems.push(skener.nextLine());
        }
        for (int i = 0; i < candidatesCount; i++) {
            String name=skener.nextLine();
            Matcher matcher=Pattern.compile("^([A-Z]{1}[a-z]+ [A-Z]{1}[a-z]+)$").matcher(name);
            if(matcher.find()){
                candidates.push(name);
            }
        }

        while (true){
            if(candidates.size()==1){
                System.out.println(candidates.pop()+" gets the job!");
                break;
            }else if(problems.size()==0){
                 List<String> test=new ArrayList<>();
                 int size=candidates.size();
                for (int i = 0; i < size; i++) {
                    test.add(candidates.pollLast());
                }
                System.out.println(String.join(", ",test));
                 break;
            }
             //purva vzimame sumite na problemite ot ascii i na userite ot ascii pak
             String candicate=candidates.peekLast();
             String problem=problems.peek();

             int sumCandicate=0;
             int sumProblem=0;

             char[] candicateWord=candicate.toCharArray();
             char[] problemWord=problem.toCharArray();

            for (int i = 0; i < candicateWord.length; i++) {
                sumCandicate+=(int)candicateWord[i];
            }

            for (int i = 0; i < problemWord.length; i++) {
                sumProblem+=(int)problemWord[i];
            }

            if(sumCandicate>sumProblem){
                System.out.println(candicate+" solved "+problems.pop()+".");
                candidates.pollLast();
                candidates.push(candicate);
            }else{
                System.out.println(candidates.pollLast()+" failed "+problem+".");
                problems.pop();
                problems.addLast(problem);
            }
        }
    }
}