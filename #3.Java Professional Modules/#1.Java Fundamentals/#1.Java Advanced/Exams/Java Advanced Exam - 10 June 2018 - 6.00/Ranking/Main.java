import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        Map<String, String> contestAndPass = new HashMap<>();

        Map<String,Map<String,Integer>> userAndInfo=new LinkedHashMap<>();
        while (true) {
            String line = skener.nextLine();
            if (line.equals("end of contests")) {
                break;
            }
            String[] splitted = line.split(":");

            String contest = splitted[0];
            String contestPassword = splitted[1];

            contestAndPass.put(contest, contestPassword);
        }

        while (true) {
            String line = skener.nextLine();
            if (line.equals("end of submissions")) {
                break;
            }
            String[] splitted = line.split("=>");
            String contest=splitted[0];
            String contestPassword=splitted[1];
            String user=splitted[2];
            int userPoints=Integer.parseInt(splitted[3]);

            if(contestAndPass.containsKey(contest)){
                if(contestAndPass.get(contest).equals(contestPassword)){
                    //purva & vtora proverka za validaciq na ime i parola na contesta
                     if(userAndInfo.containsKey(user)){
                         //shte praq proverka za tochki i t.n
                         if(userAndInfo.get(user).containsKey(contest)){
                              if(userAndInfo.get(user).get(contest)<userPoints){
                                  userAndInfo.get(user).put(contest,userPoints);
                              }
                         }else{
                             userAndInfo.get(user).put(contest,userPoints);
                         }
                     }else{
//                         userAndInfo.put(user,new LinkedList<>());
//                         userAndInfo.get(user).add(new Info(contest,userPoints));
                         userAndInfo.put(user,new LinkedHashMap<>());
                         userAndInfo.get(user).put(contest,userPoints);
                     }
                }
            }
        }
        Map<String,Integer> userAndSum=new LinkedHashMap<>();
        userAndInfo.entrySet().stream().forEach(x->{
            int sum=0;
                 sum+=userAndInfo.get(x.getKey()).values().stream()
                         .reduce(0,Integer::sum);
                 userAndSum.put(x.getKey(),sum);
        });
        userAndSum.entrySet().stream().sorted((x1,x2)->x2.getValue().compareTo(x1.getValue())).limit(1).forEach(x->{
            System.out.println("Best candidate is "+x.getKey()+" with total "+x.getValue()+" points.");
        });
        System.out.println("Ranking: ");

        userAndInfo.entrySet().stream().sorted((x1,x2)-> x1.getKey().compareTo(x2.getKey())).forEach(x->{
            System.out.println(x.getKey());
            userAndInfo.get(x.getKey()).entrySet().stream()
                    .sorted((x1,x2)->x2.getValue().compareTo(x1.getValue()))
                    .forEach(a->{
                        System.out.println("#  "+a.getKey()+" -> "+a.getValue());
                    });
        });
    }

    static class Info{

        private String contest;
        private Integer userPoints;

        public Info(String contest, Integer userPoints) {
            this.contest = contest;
            this.userPoints = userPoints;
        }

        public String getContest() {
            return contest;
        }

        public void setContest(String contest) {
            this.contest = contest;
        }

        public Integer getUserPoints() {
            return userPoints;
        }

        public void setUserPoints(Integer userPoints) {
            this.userPoints = userPoints;
        }
    }
}