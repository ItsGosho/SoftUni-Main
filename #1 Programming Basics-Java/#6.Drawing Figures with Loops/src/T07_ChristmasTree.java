import java.util.Scanner;

public class T07_ChristmasTree {
    //Gosho---------------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n; i++) {
            System.out.printf("%s%s | %s\n",repeatStr(" ",n-i),repeatStr("*",i),repeatStr("*",i));
        }
    }
    static String repeatStr(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

}
