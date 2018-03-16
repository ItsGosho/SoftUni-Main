import java.util.Scanner;

public class T05_RecursiveDrawing {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int vhod=Integer.parseInt(skener.nextLine());
        recursiveDrawingTop(vhod,vhod);
    }
    public static int recursiveDrawingTop(int vhod,int memory){
          if(vhod==0){
              return recursiveDrawingBot(memory,1);
          }
              System.out.println(repeatStr("*",vhod));
              return recursiveDrawingTop(vhod-=1,memory);
    }
    public static int recursiveDrawingBot(int memory,int zero){
        if(zero==memory){
            return memory;
        }
        System.out.println(repeatStr("#",zero));
        return recursiveDrawingBot(memory,zero+=1);
    }
    static String repeatStr(String strToRepeat, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text = text + strToRepeat;
        }
        return text;
    }

}
