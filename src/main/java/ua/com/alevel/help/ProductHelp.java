package ua.com.alevel.help;

import ua.com.alevel.dao.ProductDao;
import ua.com.alevel.model.Product;

import java.util.Scanner;

public class ProductHelp {

    private static final ProductDao productDao = new ProductDao();

    public static void createProduct(Scanner scanner){
        System.out.println("Please, enter name of product");
        String name = scanner.nextLine();
        System.out.println("Please, enter price");
        double price = scanner.nextDouble();
        System.out.println("Please, enter category id");
        int categoryId = scanner.nextInt();
        Product product = ProductDao.buildProduct(name,price,categoryId);
        productDao.insertNewProduct(product);
    }
    public static void deleteProduct(Scanner scanner){
        System.out.println("Please, enter name of product");
        String name = scanner.nextLine();
        productDao.deleteProduct(name);
    }

    public static void showProduct(){
        productDao.showProducts();
    }
}
