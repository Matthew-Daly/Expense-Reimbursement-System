package dao;

import model.User;
import daodriver.JDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public boolean insertAccount(User user) {

        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)) {

            String sql = "INSERT INTO ers_users (ers_user_name, ers_password, user_first_name, user_last_name, user_email, user_role_id)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getFirstName());
            ps.setString(4,user.getLastName());
            ps.setString(5,user.getEmail());
            ps.setInt(6,user.getRoleId());

            return ps.executeUpdate() != 0;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)) {

            String sql = "SELECT * FROM ers_users";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                users.add(
                        new User(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getInt(7)
                        ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println(users);
        return users;
    }


    @Override
    public User selectUserById(int userId) {
        User user = null;

        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)){

            String sql = "SELECT * FROM ers_users WHERE ers_users_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);


            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user =
                        new User(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getInt(7)
                        );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }

    @Override
    public User getUserRoleById(int userId) {
        User user = null;

        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)){

            String sql = "SELECT * FROM ers_users WHERE ers_users_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);


            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user =
                        new User(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getInt(7)
                        );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }

    @Override
    public User login(String userName, String password) {

        User user = null;

        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)){

            String sql = "SELECT * FROM ers_users WHERE ers_users=?";

            PreparedStatement ps = conn.prepareStatement(sql);



            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user =
                        new User(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getInt(7)
                        );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }

    @Override
    public User getUserByUserName(String userName) {
        User user = null;

        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)){

            String sql = "SELECT * FROM ers_users WHERE ers_user_name=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);


            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user =
                        new User(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getInt(7)
                        );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public String getUserName(int authorId) {
        String firstName = "";
        String lastName = "";
        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)){

            String sql = "SELECT user_first_name, user_last_name FROM ers_users WHERE ers_users_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, authorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                firstName = rs.getString(1);
                lastName = rs.getString(2);
            }


        }catch(SQLException e){
            e.printStackTrace();
        }



        String fullName = firstName + " " + lastName;
        return fullName;
    }


    public static void main(String[] args) {
//        User user = new User("KimmySchmidt", "Unbreakable", "Erin", "Hannon", "erin@dunderMifflin.com", 10);
//        User user = new User("Nard-Dog", "BonerChamp", "Andy", "Bernard", "andy@dunderMifflin.com", 6);
        UserDao userDao = new UserDaoImpl();
//        userDao.insertAccount(user);
//        userDao.selectAllUsers();
//        userDao.selectUserById(1);
        System.out.println(userDao.selectUserById(1));
//


    }
}
