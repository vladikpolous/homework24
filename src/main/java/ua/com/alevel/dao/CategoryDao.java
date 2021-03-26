package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.model.Category;
import ua.com.alevel.util.HibernateSessionUtil;

import java.util.List;

public class CategoryDao {
    private final SessionFactory sessionFactory = HibernateSessionUtil.getSessionFactory();

    public void insertNewCategory(Category category) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        }
    }

    public List<Category> getAllCategory() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Category> categoryQuery = session.createQuery("From Category", Category.class);
            List<Category> resultList = categoryQuery.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }

    public void showCategories() {
        List<Category> categoryList = getAllCategory();
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }

    public static Category buildCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return category;
    }
}
