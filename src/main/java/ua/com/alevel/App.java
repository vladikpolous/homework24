package ua.com.alevel;

import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.help.CategoryHelp;
import ua.com.alevel.help.OrderHelp;
import ua.com.alevel.help.ProductHelp;
import ua.com.alevel.help.UserHelp;

import java.util.Scanner;

public class App {
    static final String CREATE_CATEGORY = "Create category";
    static final String SHOW_CATEGORIES = "Show categories";
    static final String CREATE_PRODUCT = "Create product";
    static final String DELETE_PRODUCT = "Delete product";
    static final String CREATE_ORDER = "Create order";
    static final String DELETE_ORDER = "Delete order";
    static final String SHOW_ORDERS = "Show order";
    static final String CREATE_USER = "Create user";
    static final String DELETE_USER = "Delete user";
    static final String SHOW_USERS = "Show users";
    static final String SHOW_PRODUCTS = "Show products";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want?");
        String choice = scanner.nextLine();
        switch (choice) {
            case CREATE_CATEGORY:
                CategoryHelp.createCategory(scanner);
                break;
            case SHOW_CATEGORIES:
                CategoryHelp.showCategory();
                break;
            case CREATE_USER:
                UserHelp.createUser(scanner);
                break;
            case SHOW_USERS:
                UserHelp.showUser();
                break;
            case DELETE_USER:
                UserHelp.deleteUser(scanner);
                break;
            case CREATE_PRODUCT:
                ProductHelp.createProduct(scanner);
                break;
            case DELETE_PRODUCT:
                ProductHelp.deleteProduct(scanner);
                break;
            case SHOW_PRODUCTS:
                ProductHelp.showProduct();
                break;
            case SHOW_ORDERS:
                OrderHelp.showOrder();
                break;
            case CREATE_ORDER:
                OrderHelp.createOrder(scanner);
                break;
            case DELETE_ORDER:
                OrderHelp.deleteOrder(scanner);
                break;
            default:
                System.out.println("Something went wrong!!");
        }
    }
}
