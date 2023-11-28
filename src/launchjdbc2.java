import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class launchjdbc2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
        1. load and register the driver
        2. establish the connection
        3. statement object
        4. executeQuery
        5. process result set // while fetching the data we get resultset otherwise we don't get
        6. close the resources
        7. handling all the exception.
         */

        // 1. load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // this step is optional from jdbc 4

        // 2.establish the connection
        String url="jdbc:mysql://localhost:3306/jdbc";
        String userName="root";
        String password="root@123";
       Connection connect =  DriverManager.getConnection(url,userName,password);

       //3. statement object
        Statement statement = connect.createStatement();

        //4. executeQuery
        String query="insert into studentdetails (id,sname,age,gender) values(5,'Sriram',20,'M')";
        int rowsEffected = statement.executeUpdate(query);
        if(rowsEffected!=0)
            System.out.println("check db");
        else
            System.out.println("failed to add");
        //5. resource close
        statement.close();
        connect.close();

        //6. handle the exception.
    }
}
