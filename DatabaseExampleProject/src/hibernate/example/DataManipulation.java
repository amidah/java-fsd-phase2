package hibernate.example;


import hibernate.example.onetomany.mapping.Question;
import hibernate.example.onetomany.mapping.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

import java.lang.reflect.Array;
import java.util.ArrayList;
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


//    List<Employee> empList = session.createQuery("FROM Employee").list();
//
//    System.out.println(empList);

//    Employee emp = new Employee();
//    emp.setId(1);
//    session.delete(emp);

//    ArrayList<String> list1 = new ArrayList<>();
//    list1.add("Hibernate is an ORM tool.");
//    list1.add("Hibernate does lazy initialization.");
//
//    ArrayList<String> list2 = new ArrayList<>();
//    list2.add("Servlet is an interface.");
//    list2.add("Servlet can be Generic or Http.");
//
//    Question question1 = new Question();
//    question1.setqName("What is Hibernate?");
//    question1.setAnswers(list1);
//
//    Question question2 = new Question();
//    question2.setqName("What is Servlet?");
//    question2.setAnswers(list2);
//
//    session.persist(question1);
//    session.persist(question2);

    Answer answer1 = new Answer();
    answer1.setAnswerName("One-To-Many");
    answer1.setPostedBy("James");
    Answer answer2 = new Answer();
    answer2.setAnswerName("Many-To-One");
    answer2.setPostedBy("James");
    Answer answer3 = new Answer();
    answer3.setAnswerName("One-To-One");
    answer3.setPostedBy("James");
    Answer answer4 = new Answer();
    answer4.setAnswerName("Many-To-Many");
    answer4.setPostedBy("James");

    List<Answer> answerList1 = new ArrayList<>();
    answerList1.add(answer1);
    answerList1.add(answer2);
    answerList1.add(answer3);
    answerList1.add(answer4);

    Answer answer5 = new Answer();
    answer5.setAnswerName("java.util.List");
    answer5.setPostedBy("Robert");
    Answer answer6 = new Answer();
    answer6.setAnswerName("java.util.Set");
    answer6.setPostedBy("Robert");
    Answer answer7 = new Answer();
    answer7.setAnswerName("java.util.SortedSet");
    answer7.setPostedBy("Robert");
    Answer answer8 = new Answer();
    answer8.setAnswerName("java.util.Map");
    answer8.setPostedBy("Robert");
    Answer answer9 = new Answer();
    answer9.setAnswerName("java.util.SortedMap");
    answer9.setPostedBy("Robert");
    Answer answer10 = new Answer();
    answer10.setAnswerName("java.util.Collection");
    answer10.setPostedBy("Robert");

    List<Answer> answerList2 = new ArrayList<>();
    answerList2.add(answer5);
    answerList2.add(answer6);
    answerList2.add(answer7);
    answerList2.add(answer8);
    answerList2.add(answer9);
    answerList2.add(answer10);

    Question question1 = new Question();
    question1.setqName("Different types of mapping in hibernate?");
    question1.setAnswerList(answerList1);

    Question question2 = new Question();
    question2.setqName("Collection type supported in hibernate?");
    question2.setAnswerList(answerList2);

    session.persist(question1);
    session.persist(question2);

    transaction.commit();
    session.close();
    sessionFactory.close();
  }
}
