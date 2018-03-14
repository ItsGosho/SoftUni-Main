import java.util.Scanner;

public class T01_CountSubstringOccurrences {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String text = skener.nextLine().toLowerCase();
        String pattern = skener.nextLine().toLowerCase();
        StringBuilder str = new StringBuilder(text);
        int count = 0;
        while (true) {
            if (text.contains(pattern)) {
                int first = str.indexOf(pattern);
                int last = first + pattern.length() - 1;
                str = str.delete(first, last);
                text = str.toString();
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
