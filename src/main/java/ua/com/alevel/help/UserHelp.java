package ua.com.alevel.help;

import ua.com.alevel.dao.UserDao;
import ua.com.alevel.model.User;

import java.util.Scanner;

public class UserHelp {

    private static final UserDao userDao = new UserDao();

    public static void createUser(Scanner scanner){
        System.out.println("Please, enter nickname");
        String nickname = scanner.nextLine();
        System.out.println("Please, enter email");
        String email = scanner.nextLine();
        System.out.println("Please, enter address");
        String address = scanner.nextLine();
        User user = UserDao.buildUser(nickname,email,address);
        userDao.insertNewUser(user);
    }

    public static void deleteUser(Scanner scanner){
        System.out.println("Please, enter nickname");
        String nickname = scanner.nextLine();
        userDao.deleteUser(nickname);
    }
    public static void showUser(){
        userDao.showUsers();
    }

}
