import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class T04_Change_Town_Name_Casing {
    //Gosho------------------------------>
    public static void main(String[] args) throws SQLException {
        Scanner skener = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "PASSWORD");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", properties);

        PreparedStatement prpChange=
                connection.prepareStatement("update town\n" +
                        "set name=UPPER(name)\n" +
                        "where information=?;");
        String country=skener.nextLine();
        prpChange.setString(1,country);
        prpChange.executeUpdate();

        PreparedStatement prpGet=
                connection.prepareStatement("select t.name\n" +
                        "from town as t\n" +
                        "where information=?;");
        prpGet.setString(1,country);
        ResultSet rsGet=prpGet.executeQuery();


        if(rsGet.isBeforeFirst()){
            List<String> towns=new ArrayList<>();
            int townsCount=0;
            while (rsGet.next()) {
                towns.add(rsGet.getString("name"));
                townsCount++;
            }
            System.out.println(townsCount+" town names were affected. ");
            System.out.println("["+String.join(", ",towns)+"]");
        }else{
            System.out.println("No town names were affected.");
        }
    }
}
