import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class T03_Add_Minion {
    //Gosho------------------------------>
    public static void main(String[] args) throws SQLException {
        Scanner skener = new Scanner(System.in);


        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "PASSWORD");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", properties);


        String[] minionRead=skener.nextLine().split(" ");
        String minionName=minionRead[1];
        int minionAge=Integer.parseInt(minionRead[2]);
        String minionTown=minionRead[3];
        String[] villianRead=skener.nextLine().split(" ");
        String villianName=villianRead[1];

        PreparedStatement townCheckStatemnt =
                connection.prepareStatement("select t.name\n" +
                        "from town as t\n" +
                        "where t.name=?;");
        townCheckStatemnt.setString(1,minionTown);
        ResultSet resultSetTown=townCheckStatemnt.executeQuery();
            resultSetTown.next();
        if(resultSetTown.next()){
            //there is
            if(checkIsThereVillian(connection,villianName)){
                addMinion(connection,minionName,minionAge,minionTown);
            }else{
                insrtVillian(connection,villianName);
            }
        }else{
            //there`s not
            PreparedStatement insrtTownStatemnt =
                    connection.prepareStatement("insert into town(name,information) values (?,?);");
            insrtTownStatemnt.setString(1,minionTown);
            insrtTownStatemnt.setString(2,"div grad");
            ResultSet insrtSetTown=townCheckStatemnt.executeQuery();

            if(checkIsThereVillian(connection,villianName)){
                addMinion(connection,minionName,minionAge,minionTown);
            }else{
                insrtVillian(connection,villianName);
            }
        }
    }
    public static boolean checkIsThereVillian(
            Connection connection,
            String villianName
    ) throws SQLException {
        PreparedStatement villianCheckStatemnt =
                connection.prepareStatement("select v.name\n" +
                        "from villian as v\n" +
                        "where v.name=?;");
        villianCheckStatemnt.setString(1,villianName);
        ResultSet resultSetVillian=villianCheckStatemnt.executeQuery();
        if(resultSetVillian.next()){
            return true;
        }
        return false;
    }

    public static void insrtVillian(Connection connection,
                                    String villianName) throws SQLException {
        PreparedStatement insertVillianStatement =
                connection.prepareStatement("insert into villian(name,evilness) values (?,\"evil\");");
        insertVillianStatement.setString(1,villianName);
        ResultSet insrtVillian=insertVillianStatement.executeQuery();
    }

    public static void addMinion(Connection connection,
                                 String minionName,
                                 int minionAge,
                                 String minionTown) throws SQLException {
        PreparedStatement insrtMinionStatemnt =
                connection.prepareStatement("insert into minion(name,age,town) values (?,?,?);");
        insrtMinionStatemnt.setString(1,minionName);
        insrtMinionStatemnt.setInt(2,minionAge);
        insrtMinionStatemnt.setString(3,minionTown);
        ResultSet insrtMinionSet=insrtMinionStatemnt.executeQuery();
    }
}
