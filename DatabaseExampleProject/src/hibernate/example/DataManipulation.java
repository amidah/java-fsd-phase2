package hibernate.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

import java.util.List;


public class DataManipulation {

  public static void main (String[] args) {

    SessionFactory sessionFactory = new Configuration().configure("hibernate/example/hibernate.cfg.xml").buildSessionFactory();

    Session session = sessionFactory.openSession();

    Transaction transaction = session.beginTransaction();

//    Employee emp1 = new Employee();
//    emp1.setFirstName("DWYANE");
//    emp1.setLastName("JOHNSON");
//
//    session.save(emp1);

//    Employee emp = session.get(Employee.class, 1);

//    System.out.println(emp);


    List<Employee> empList = session.createQuery("FROM Employee").list();

    System.out.println(empList);

//    Employee emp = new Employee();
//    emp.setId(1);
//    session.delete(emp);

    transaction.commit();
    session.close();
    sessionFactory.close();
  }
}
