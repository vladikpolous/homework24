package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.model.Order;
import ua.com.alevel.model.Product;
import ua.com.alevel.model.User;
import ua.com.alevel.util.HibernateSessionUtil;


import java.sql.Timestamp;
import java.util.List;

public class OrderDao {
    private final SessionFactory sessionFactory = HibernateSessionUtil.getSessionFactory();
    public void insertNewOrder(Order order) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }
    }
    public List<Order> getAllOrder() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Order> productQuery = session.createQuery("From Order", Order.class);
            List<Order> resultList = productQuery.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }
    public void showOrders() {
        List<Order> orderList = getAllOrder();
        for (Order order :
                orderList) {
            System.out.println(order);
        }
    }
    public void deleteOrder(int orderId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("Delete from Order WHERE orderId =: orderId");
            query.setParameter("orderId", orderId);
            session.getTransaction().commit();
        }
    }
    public Order buildOrder(Product product, User user,  int quantity, Timestamp orderTime) {
        Order order = new Order();
        order.setProduct(product);
        order.setUser(user);
        order.setQuantity(quantity);
        order.setOrderTime(orderTime);
        return order;
    }
}
