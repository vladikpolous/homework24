package ua.com.alevel.help;

import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.model.Category;

import java.util.Scanner;

public class CategoryHelp {
    private static final CategoryDao categoryDao = new CategoryDao();

    public static void createCategory(Scanner scanner){
        System.out.println("Please, enter name of category");
        String name = scanner.nextLine();
        Category category = CategoryDao.buildCategory(name);
        categoryDao.insertNewCategory(category);
    }

    public static void showCategory(){
        categoryDao.showCategories();
    }
}
