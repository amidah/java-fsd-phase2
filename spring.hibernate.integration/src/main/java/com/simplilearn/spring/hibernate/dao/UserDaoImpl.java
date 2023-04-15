package com.simplilearn.spring.hibernate.dao;


import com.simplilearn.spring.hibernate.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;


  @Transactional
  public void save () {

    Session session = sessionFactory.getCurrentSession();
    User user = new User(101, "Sam", 29, "sam@gmail.com");
    session.save(user);
  }
}
