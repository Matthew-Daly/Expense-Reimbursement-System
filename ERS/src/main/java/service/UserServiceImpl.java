package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getAll() {
        return userDao.selectAllUsers();
    }

    @Override
    public User getUserById(int userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public User validateLogin(String username, String password) {
        User user = userDao.getUserByUserName(username);
        if(user == null){
            return null;
        } else if (!user.getPassword().equals(password)){
            return null;
        } else {
            return user;
        }
    }

    @Override
    public String getUserName(int authorId) {
        return userDao.getUserName(authorId);
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
//        System.out.println(userService.validateLogin("DateMike", "SheSaid"));
        System.out.println(userService.getUserName(1));
    }

}
