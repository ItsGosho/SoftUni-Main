import java.util.Scanner;

public class T01_StudentsResults {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split("[\\,\\-]\\s+");
        String name=line[0];
        double JAdv=Double.parseDouble(line[1]);
        double OOP=Double.parseDouble(line[2]);
        double AdvOOP=Double.parseDouble(line[3]);
        double average=(JAdv+OOP+AdvOOP)/3;
        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|"
        ,"Name","JAdv","JavaOOP","AdvOOP","Average"));
        System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                name,JAdv,OOP,AdvOOP,average));
    }
}
