import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        int n=Integer.parseInt(skener.nextLine());
        String[][] matrica=new String[n][n];

        String[] moves=skener.nextLine().split(", ");

        int startCol=0;
        int startRow=0;
        long totalFoundInTheMatrica=0;
        for (int i = 0; i < n; i++) {
            String line=skener.nextLine();
            String[] splitted=line.split(" ");
            for (int j = 0; j < n; j++) {

                matrica[i][j]=splitted[j];
                if(matrica[i][j].equals("s")){
                    startCol=i;
                    startRow=j;
                }else if(matrica[i][j].equals("f")){
                    totalFoundInTheMatrica++;
                }
            }
        }

        int currCol=startCol;
        int currRow=startRow;
        long snakeLength=1;
        long leftFood=totalFoundInTheMatrica;
        boolean killedByEnemy=false;
        for (int i = 0; i < moves.length; i++) {

            switch (moves[i]){
                case "up":
                    //stiga do gore i s IF smenqme i otiva dolu
                    if(currCol-1<0){
                        currCol=n-1;
                    }else{
                        currCol--;
                    }
                    if(matrica[currCol][currRow].equals("f")){
                        snakeLength++;
                        leftFood--;
                    }else if(matrica[currCol][currRow].equals("e")){
                        //GAME OVER
                        i=moves.length;
                        System.out.println("You lose! Killed by an enemy!");
                        killedByEnemy=true;
                        break;
                    }
                    break;

                case "down":
                    //stiga do dolu i s IF smenqme i otiva dolu
                    if(currCol+1==n){
                        currCol=0;
                    }else{
                        currCol++;
                    }

                    if(matrica[currCol][currRow].equals("f")){
                        snakeLength++;
                        leftFood--;
                    }else if(matrica[currCol][currRow].equals("e")){
                        //GAME OVER
                        i=moves.length;
                        System.out.println("You lose! Killed by an enemy!");
                        killedByEnemy=true;
                        break;
                    }
                    break;

                case "left":
                    //stiga do lqvo i s IF smenqme i otiva dolu
                    if(currRow-1<0){
                        currRow=n-1;
                    }else{
                        currRow--;
                    }

                    if(matrica[currCol][currRow].equals("f")){
                        snakeLength++;
                        leftFood--;
                    }else if(matrica[currCol][currRow].equals("e")){
                        //GAME OVER
                        i=moves.length;
                        System.out.println("You lose! Killed by an enemy!");
                        killedByEnemy=true;
                        break;
                    }
                    break;

                case "right":
                    //stiga do dqsno i s IF smenqme i otiva dolu
                    if(currRow+1==n){
                        currRow=0;
                    }else{
                        currRow++;
                    }

                    if(matrica[currCol][currRow].equals("f")){
                        snakeLength++;
                        leftFood--;
                    }else if(matrica[currCol][currRow].equals("e")){
                        //GAME OVER
                        i=moves.length;
                        if(leftFood<=0){
                            System.out.println("You win! Final snake length is "+snakeLength);
                        }else {
                            System.out.println("You lose! Killed by an enemy!");
                        }
                        killedByEnemy=true;
                        break;
                    }
                    break;
            }
        }
        if(leftFood<=0 && killedByEnemy==false){
            System.out.println("You win! Final snake length is "+snakeLength);
        }else if(leftFood>0 &&
                killedByEnemy==false){
            System.out.println("You lose! There is still "+leftFood+" food to be eaten.");
        }
    }
    public static void printiraiMatrica(String[][] matrica){

        for (int i = 0; i < matrica.length; i++) {

            for (int j = 0; j < matrica[i].length; j++) {
                System.out.print(matrica[i][j]+" ");
            }
            System.out.println();
        }
    }
}