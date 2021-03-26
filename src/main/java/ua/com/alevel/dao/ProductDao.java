package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.model.Product;
import ua.com.alevel.util.HibernateSessionUtil;

import java.util.List;

public class ProductDao {
    private final SessionFactory sessionFactory = HibernateSessionUtil.getSessionFactory();

    public void insertNewProduct(Product product) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }
    public Product getProductByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Product> query = session.createQuery("FROM Product where name = :name", Product.class);
            query.setParameter("name", name);
            return query.getResultList().get(0);
        }
    }
    public List<Product> getAllProduct() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Product> productQuery = session.createQuery("From Product", Product.class);
            List<Product> resultList = productQuery.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }

    public void showProducts() {
        List<Product> productsList = getAllProduct();
        for (Product product :
                productsList) {
            System.out.println(product);
        }
    }

    public void deleteProduct(String name) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("Delete from Product WHERE name =: name");
            query.setParameter("name", name);
            session.getTransaction().commit();
        }
    }

    public static Product buildProduct(String name, double price, int categoryId) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        return product;
    }
}
