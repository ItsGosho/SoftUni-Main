import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class T01_Get_Villians_Names {
    //Gosho------------------------------>
    public static void main(String[] args) throws SQLException {
        Scanner skener = new Scanner(System.in);
        

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "PASSWORD");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", properties);


        PreparedStatement preparedStatement =
                connection.prepareStatement("select distinct v.name as name,(\n" +
                        "select count(Jm.id)\n" +
                        "from minion as Jm\n" +
                        "join villian_minion as Jvm on Jvm.minion_id=Jm.id\n" +
                        "where Jm.id=vm.minion_id\n" +
                        ") as 'count'\n" +
                        "from villian as v \n" +
                        "join villian_minion as vm on vm.villian_id=v.id\n" +
                        "where 'count'>3\n" +
                        "order by count desc;");


        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            System.out.println(resultSet.getString("name")+" "+
            resultSet.getString("count"));
        }
    }
}
