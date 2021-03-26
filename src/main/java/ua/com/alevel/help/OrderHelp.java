package ua.com.alevel.help;

import org.hibernate.SessionFactory;
import ua.com.alevel.dao.OrderDao;
import ua.com.alevel.dao.ProductDao;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.model.Order;
import ua.com.alevel.model.Product;
import ua.com.alevel.model.User;
import ua.com.alevel.util.HibernateSessionUtil;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class OrderHelp {
    private static final OrderDao orderDao = new OrderDao();
    private static final ProductDao productDao = new ProductDao();
    private static final UserDao userDao = new UserDao();


    public static void createOrder(Scanner scanner) {
        System.out.println("Choose and enter a product name from the list:");
        ProductHelp.showProduct();
        Product product;
        String name = scanner.nextLine();

        product = productDao.getProductByName(name);

        System.out.println("Enter user's email");
        String email = scanner.nextLine();
        User user;

        user = userDao.getUserByEmail(email);
        System.out.println("How many products you want to add to the order?");
        int quantity = scanner.nextInt();
        Timestamp orderTime = Timestamp.valueOf(LocalDateTime.now());

        Order order = orderDao.buildOrder(product, user, quantity, orderTime);
        orderDao.insertNewOrder(order);
    }

    public static void showOrder() {
        orderDao.showOrders();
    }
    public static void deleteOrder(Scanner scanner){
        System.out.println("Please, enter order id");
        int orderId = scanner.nextInt();
        orderDao.deleteOrder(orderId);
    }
}
