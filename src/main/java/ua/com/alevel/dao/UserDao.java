package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.model.User;
import ua.com.alevel.util.HibernateSessionUtil;

import java.util.List;

public class UserDao {
    private final SessionFactory sessionFactory = HibernateSessionUtil.getSessionFactory();

    public void insertNewUser(User user){
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public List<User> getAllUser(){
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query<User> userQuery = session.createQuery("From User",User.class);
            List<User> resultList = userQuery.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }
    public void showUsers(){
        List<User> userList = getAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    public void deleteUser(String nickname){
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query query = session.createQuery("Delete from User WHERE nickname =: nickname");
            query.setParameter("nickname",nickname);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
    public User getUserByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User where email = :email", User.class);
            query.setParameter("email", email);
            return query.getResultList().get(0);
        }
    }
    public static User buildUser(String nickname, String email, String address){
        User user = new User();
        user.setNickname(nickname);
        user.setAdress(address);
        user.setEmail(email);
        return user;

    }
}
