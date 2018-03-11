import java.util.Scanner;

public class T03_ParseTags {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String line=skener.nextLine();
        StringBuilder str=new StringBuilder(line);
        String vremenna="";
        while(true){
            int start=str.indexOf("<upcase>");
            int end=str.indexOf("</upcase>");
            if(start==-1){
                    break;
            }
            vremenna=str.substring(start+8,end);
            vremenna=vremenna.toUpperCase();
            str=str.replace(start,end+9,vremenna);
        }
        System.out.println(str);
    }
}
