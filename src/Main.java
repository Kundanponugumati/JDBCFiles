
import com.sun.security.jgss.GSSUtil;

import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Hello world!");

        // load and register the driver.
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver is registered");
        // establish connection
        String url="jdbc:mysql://localhost:3306/jdbc";
        String userName="root";
        String password="root@123";

        Connection connect = DriverManager.getConnection(url,userName,password); // returns Connection object.
        System.out.println("Connection established");

        // create statement object
        Statement statement = connect.createStatement();
        System.out.println("Statement object is ready");

        // execute query
        String query ="select * from studentdetails";
        ResultSet rs = statement.executeQuery(query);
        System.out.println("we have got result set");

        // process result set.
        System.out.println("id\tname\tage\tgender");
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"
                    +rs.getInt(3)+"\t"+rs.getString(4));
        }

        // closing the connection
        rs.close();
        statement.close();
        connect.close();

        // last step is handling all the exceptions.
    }
}