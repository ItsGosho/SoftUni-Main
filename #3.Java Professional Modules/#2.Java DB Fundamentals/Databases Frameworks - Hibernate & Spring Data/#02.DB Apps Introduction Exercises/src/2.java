import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class T02_Get_Minion_Names {
    //Gosho------------------------------>
    public static void main(String[] args) throws SQLException {
        Scanner skener = new Scanner(System.in);


        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "PASSWORD");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", properties);


        PreparedStatement villianNameStatement =
                connection.prepareStatement("select v.name as name\n" +
                        "from villian as v\n" +
                        "where v.id=?");
        int vId=Integer.parseInt(skener.nextLine());
        villianNameStatement.setInt(1,vId);
        ResultSet resultSetName = villianNameStatement.executeQuery();

        resultSetName.next();

        try{
            System.out.println("Villain: "+resultSetName.getString("name"));
            PreparedStatement villianAndHisMinions =
                    connection.prepareStatement("select distinct m.name as name,m.age as age\n" +
                            "from minion as m\n" +
                            "join villian_minion as Vm on Vm.minion_id=m.id\n" +
                            "join villian as v on Vm.villian_id=v.id\n" +
                            "where v.id=?");
            villianAndHisMinions.setInt(1,vId);
            ResultSet resultSetVM=villianAndHisMinions.executeQuery();

            int counter=1;
            if(!resultSetVM.next()){
                System.out.println("<no minions>");
            }else {
                while (resultSetVM.next()) {
                    System.out.println(counter + ". " + resultSetVM.getString("name") + " " +
                            resultSetVM.getString("age"));
                    counter++;
                }
            }

        }catch (SQLException ex){
            System.out.println("No villain with ID "+vId+" exists in the database.");
        }
    }
}
