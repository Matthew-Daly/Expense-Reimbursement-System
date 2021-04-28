package dao;

import daodriver.JDBC;
import model.Reimbursement;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDaoImpl implements ReimbursementDao {


    @Override
    public Boolean insertReimbursement(Reimbursement reimbursement) {
        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)) {



            String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_type_id)" +
                    "VALUES (?, current_timestamp, ?, ?, ?);";



            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1,reimbursement.getAmount());
            ps.setString(2,reimbursement.getDescription());
            ps.setInt(3,reimbursement.getAuthor());
            ps.setInt(4,reimbursement.getTypeId());

            return ps.executeUpdate() != 0;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Reimbursement> selectAllReimbursements() {
        List<Reimbursement> reimbursements = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)) {

            String sql = "SELECT * FROM ers_reimbursement";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                reimbursements.add(
                        new Reimbursement(rs.getInt(1),
                                rs.getDouble(2),
                                rs.getTimestamp(3),
                                rs.getTimestamp(4),
                                rs.getString(5),
                                rs.getBlob(6),
                                rs.getInt(7),
                                rs.getInt(8),
                                rs.getInt(9),
                                rs.getInt(10)
                        ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

//        System.out.println(reimbursements);
        return reimbursements;
    }

    @Override
    public List<Reimbursement> selectAllReimbursementsByStatus(int status) {
        List<Reimbursement> reimbursements = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)) {

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, status);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                reimbursements.add(
                        new Reimbursement(rs.getInt(1),
                                rs.getDouble(2),
                                rs.getTimestamp(3),
                                rs.getTimestamp(4),
                                rs.getString(5),
                                rs.getBlob(6),
                                rs.getInt(7),
                                rs.getInt(8),
                                rs.getInt(9),
                                rs.getInt(10)
                        ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

//        System.out.println(reimbursements);
        return reimbursements;
    }

    @Override
    public List<Reimbursement> selectAllReimbursementsById(int userId) {
        List<Reimbursement> reimbursements = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)) {

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                reimbursements.add(
                        new Reimbursement(rs.getInt(1),
                                rs.getDouble(2),
                                rs.getTimestamp(3),
                                rs.getTimestamp(4),
                                rs.getString(5),
                                rs.getBlob(6),
                                rs.getInt(7),
                                rs.getInt(8),
                                rs.getInt(9),
                                rs.getInt(10)
                        ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

//        System.out.println(reimbursements);
        return reimbursements;
    }


    @Override
    public List<Reimbursement> selectAllByResolver(int resolverId) {
        List<Reimbursement> reimbursements = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)) {

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_resolver = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, resolverId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                reimbursements.add(
                        new Reimbursement(rs.getInt(1),
                                rs.getDouble(2),
                                rs.getTimestamp(3),
                                rs.getTimestamp(4),
                                rs.getString(5),
                                rs.getBlob(6),
                                rs.getInt(7),
                                rs.getInt(8),
                                rs.getInt(9),
                                rs.getInt(10)
                        ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println(reimbursements);
        return reimbursements;
    }


    @Override
    public Reimbursement selectReimbursementById(int reimbId) {
        Reimbursement reimbursement = null;
        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)) {
            
            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbId);

            ResultSet rs = ps.executeQuery();




        } catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println(reimbursement);
        return reimbursement;
    }

    @Override
    public Reimbursement getReimbursementByResolver(int reimbResolver) {
        return null;
    }

    @Override
    public boolean updateReimbursement(int reimbId, int status) {
        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)){

            String sql = "UPDATE ers_reimbursement SET reimb_status_id = ?, reimb_resolved = NOW()" +
                    "WHERE reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, reimbId);


            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

//    @Override
//    public List<Reimbursement> SelectAllJoin() {
//        List<Reimbursement> reimbursements = new ArrayList<>();
//        try(Connection conn = DriverManager.getConnection(JDBC.url, JDBC.username, JDBC.password)) {
//
//            String sql = "SELECT * FROM ers_reimbursement\n" +
//                    "LEFT JOIN ers_reimbursement_status \n" +
//                    "ON ers_reimbursement_status.reimb_status_id = ers_reimbursement.reimb_status_id\n" +
//                    "LEFT JOIN ers_users ON ers_users.ers_users_id = ers_reimbursement.reimb_author;";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while(rs.next()){
//                reimbursements.add(
//                        new Reimbursement(rs.getInt(1),//id
//                                rs.getDouble(2),//amount
//                                rs.getTimestamp(3),//submitted
//                                rs.getTimestamp(4),//resolved
//                                rs.getString(5),//description
//                                rs.getBlob(6),//receipt
//                                rs.getInt(7),//author
//                                rs.getInt(8),//resolver
//                                rs.getInt(9),//statusId
//                                rs.getInt(10),//typeId
//                                rs.getString(11), //firstname
//                                rs.getString(12) //lastname
//
//                        ));
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//
////        System.out.println(reimbursements);
//        return reimbursements;
//    }


    public static void main(String[] args) {
        ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();
        Reimbursement reimbursement = new Reimbursement(100.00, "desk", 7, 3);
//        Timestamp dateSubmitted = new Timestamp(System.currentTimeMillis());
//        reimbursementDao.updateReimbursement(2, 1);
//        reimbursementDao.getReimbursementByResolver(4);
//        reimbursementDao.selectAllReimbursementsById(11);
//        reimbursementDao.selectAllReimbursementsByStatus(1);
        reimbursementDao.insertReimbursement(reimbursement);

    }



}
