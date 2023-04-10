package hibernate.example.onetomany.mapping;


import hibernate.example.onetomany.mapping.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;


public class FetchData {
  public static void main (String[] args) {

    SessionFactory
        sessionFactory = new Configuration().configure("hibernate/example/hibernate.cfg.xml").buildSessionFactory();

    Session session = sessionFactory.openSession();

    Transaction transaction = session.beginTransaction();

    TypedQuery typedQuery = session.createQuery("from Question");

    List<Question> questionList = typedQuery.getResultList();

    Iterator<Question> itr=questionList.iterator();
    while(itr.hasNext()){
      Question q=itr.next();
      System.out.println("Question Name: "+q.getqName());

      //printing answers
      List<Answer> list2=q.getAnswerList();
      Iterator<Answer> itr2=list2.iterator();
      while(itr2.hasNext()){
        Answer a = itr2.next();
        System.out.println(a.getAnswerName() + " : " + a.getPostedBy());
      }
    }
    transaction.commit();

    session.close();

    sessionFactory.close();
  }
}
