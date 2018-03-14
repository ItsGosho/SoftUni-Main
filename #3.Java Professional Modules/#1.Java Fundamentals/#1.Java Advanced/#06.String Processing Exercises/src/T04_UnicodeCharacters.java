import java.util.Scanner;

public class T04_UnicodeCharacters {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String line=skener.nextLine();
        char[] bukvi=line.toCharArray();
        String result="";
        for (int i = 0; i < bukvi.length; i++) {
            result+=toUnicode(bukvi[i]);
        }
        System.out.println(result);
    }
    private static String toUnicode(char ch) {
        return String.format("\\u%04x", (int) ch);
    }
}
