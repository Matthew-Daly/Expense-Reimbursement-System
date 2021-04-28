package dao;


import model.User;

import java.util.List;

public interface UserDao {

    //CREATE
    public boolean insertAccount(User user);
    public List<User> selectAllUsers();
    public User selectUserById(int userId);
    public User getUserRoleById(int userId);
    public User login(String userName, String password);
    public User getUserByUserName(String username);
    public String getUserName(int authorId);

}
