import java.util.Scanner;

public class T04_Greeting {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        String firstName=skener.nextLine();
        String secondName=skener.nextLine();
        if(firstName.equals("") && secondName.equals("")){
            System.out.println("Hello, ***** *****!");
        }else if(secondName.equals("")){
            System.out.printf("Hello, %s *****!",firstName);
        }else if(firstName.equals("")){
            System.out.printf("Hello, ***** %s!",secondName);
        }else{
            System.out.printf("Hello, %s %s!",firstName,secondName);
        }
    }
}
