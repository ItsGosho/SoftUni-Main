import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class T06_PrintAllMinionNames {
    //Gosho------------------------------>
    public static void main(String[] args) throws SQLException {
        Scanner skener = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "PASSWORD");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", properties);


        PreparedStatement preparedStatement =
                connection.prepareStatement("select m.name\n" +
                        "from minion as m\n" +
                        "where m.id=?;");

        PreparedStatement stmCount =
                connection.prepareStatement("select count(m.name) as 'broi'\n" +
                        "from minion as m;");
        ResultSet rsCount=stmCount.executeQuery();
        rsCount.next();
        int broi=rsCount.getInt("broi");

        int i2=broi;
        boolean reduvai=false;
        int minus=0;
        if(broi%2!=0){
            minus=1;
        }else{
            minus=2;
        }
        for (int i = 1; i < broi-minus; i++) {
            PreparedStatement stmGet =
                    connection.prepareStatement("select m.name\n" +
                            "from minion as m\n" +
                            "where m.id=?;");
            if(!reduvai){
                stmGet.setInt(1,i);
                reduvai=true;
            }else{
                stmGet.setInt(1,i2);
                i2--;
                i--;
                reduvai=false;
            }
            ResultSet rsGet=stmGet.executeQuery();
            rsGet.next();
            System.out.println(rsGet.getString("name"));
        }
    }
}
