import java.util.Scanner;

public class T11_GameOfNames {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
         int n=Integer.parseInt(skener.nextLine());
         String winnerName="";
        int winnerScore = Integer.MIN_VALUE;
        System.out.println(winnerScore);
        for (int i = 0; i < n; i++) {
            String name=skener.nextLine();
            int Score=Integer.parseInt(skener.nextLine());
            char[] word=name.toCharArray();
            for (int j = 0; j < name.length(); j++) {
                 if(word[j]%2==0){
                     Score+=word[j];
                 }else if(word[j]%2!=0){
                     Score-=word[j];
                 }
            }
            if(Score>winnerScore){
                winnerName=name;
                winnerScore=Score;
            }
        }
        System.out.printf("The winner is %s - %d points",winnerName,winnerScore);
    }
}
