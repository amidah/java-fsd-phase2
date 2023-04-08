import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


public class MysqlConnectionExample {

  public static void main (String[] args) {


    try {
      // 1. Register Driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      // 2. Get Connection
      Connection connection = DriverManager.getConnection(
          "jdbc:mysql://127.0.0.1:3307/employee",
          "root",
          "root123"
      );

      Random randomNum = new Random();
      // 3. Create Statement
      PreparedStatement
          preparedStmnt = connection.prepareStatement("INSERT INTO employee_registration values (?,?,?,?,?)");
      preparedStmnt.setInt(1, randomNum.nextInt());
      preparedStmnt.setString(2, "John");
      preparedStmnt.setString(3, "john123");
      preparedStmnt.setString(4, "john@yahoo.com");
      preparedStmnt.setString(5, "USA");

      // 4. Execute Query
      int i = preparedStmnt.executeUpdate();
      if(i > 0) {
        System.out.println("John" + " is registered successfully...");
      }

      // 5. Close Connection
      connection.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
