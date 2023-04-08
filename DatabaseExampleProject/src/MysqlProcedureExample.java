import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;


public class MysqlProcedureExample {

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

      // 3. Create Callable Statement
      CallableStatement callStmnt1 = connection.prepareCall("{call GET_EMPLOYEE_DETAILS()}");

      CallableStatement callStmnt2 = connection.prepareCall("{call GET_EMPLOYEE_DETAILS_BY_NAME(?)}");
      callStmnt2.setString(1,"John,Bond");

      CallableStatement callStmnt3 = connection.prepareCall("{call GET_MAX_SALARY(?)}");
      callStmnt3.registerOutParameter(1, Types.INTEGER);

      CallableStatement callStmnt4 = connection.prepareCall("{call GET_EMPLOYEE_SALARY_BY_NAME(?)}");
      callStmnt4.setString(1, "Tom");
      callStmnt4.registerOutParameter(1, Types.INTEGER);

      // 4. Execute Query
      ResultSet resultSet1 = callStmnt1.executeQuery();

      ResultSet resultSet2 = callStmnt2.executeQuery();

      callStmnt3.execute();

      callStmnt4.execute();

      System.out.println("Result set of call GET_EMPLOYEE_DETAILS() =====>> ");
      while (resultSet1.next()) {
        System.out.println(resultSet1.getString("Name") + " " + resultSet1.getString("PhoneNumber") +
                               " " + resultSet1.getString("Address") + " " + resultSet1.getString(
            "Salary"));
      }

      System.out.println("\n");

      System.out.println("Result set of call GET_EMPLOYEE_DETAILS_BY_NAME(?) =====>> ");
      while (resultSet2.next()) {
        System.out.println(resultSet2.getString("Name") + " " + resultSet2.getString("PhoneNumber") +
                               " " + resultSet2.getString("Address") + " " + resultSet2.getString(
            "Salary"));
      }

      System.out.println("\n");

      System.out.println("Result of call GET_MAX_SALARY() =====>> " + callStmnt3.getInt(1));

      System.out.println("\n");

      System.out.println("Result of call GET_EMPLOYEE_SALARY_BY_NAME() =====>> " + callStmnt4.getInt(1));


      // 5. Close Connection
      connection.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
