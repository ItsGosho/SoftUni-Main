import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class T01_Writing_your_own_data {
    //Gosho------------------------------>
    public static void main(String[] args) throws SQLException {
        Scanner skener = new Scanner(System.in);

        System.out.print("Enter username default (root): ");
        String user = skener.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();

        System.out.print("Enter password default (empty):");
        String password = skener.nextLine().trim();
        System.out.println();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", properties);


        PreparedStatement preparedStatement =
                connection.prepareStatement("select concat(u.first_name,' ',last_name) as fullname,count(ug.id) as igri\n" +
                        "from users as u\n" +
                        "join users_games as ug on ug.user_id=u.id\n" +
                        "where u.user_name=?");

        String userToFind = skener.nextLine();
        preparedStatement.setString(1, userToFind);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        if (resultSet.getString("fullname") != null) {
            System.out.println("User: "+userToFind);
            System.out.println(resultSet.getString("fullname") + " " +
                    resultSet.getInt("igri"));
        } else {
            System.out.println("No such user exists");
        }

    }
}
