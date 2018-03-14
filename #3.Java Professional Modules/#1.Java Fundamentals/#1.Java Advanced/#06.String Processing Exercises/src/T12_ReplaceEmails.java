import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T12_ReplaceEmails {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^((?:[A-Za-z0-9]+[._-]{1})*(?:[A-Za-z0-9])+)@([A-Za-z]+(?:\\-?[A-Za-z]+)+(?:\\.[A-Za-z]+(?:\\-?[A-Za-z]+)+){1,})$");

        String input = skener.nextLine();
        while (!"end".equals(input)) {
            if (input.endsWith(".")) {
                input = input.substring(0, input.length() - 1);
            }

            String[] separatedInput = input.split(",\\s+|\\s+");

            for (String currentString : separatedInput) {
                Matcher matcher = pattern.matcher(currentString);
                if (matcher.find()) {
                    System.out.println(currentString);
                }
            }
            input = skener.nextLine();
        }
    }
}
