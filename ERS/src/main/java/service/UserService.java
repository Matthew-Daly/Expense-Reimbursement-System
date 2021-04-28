package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(int userId);
    User validateLogin(String username, String password);
    String getUserName(int authorId);

}
