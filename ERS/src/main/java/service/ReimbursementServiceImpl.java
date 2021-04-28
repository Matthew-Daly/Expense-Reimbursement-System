package service;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import model.Reimbursement;

import java.sql.Timestamp;
import java.util.List;

public class ReimbursementServiceImpl implements ReimbursementService{

    ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();

    @Override
    public List<Reimbursement> getAllByResolver(int resolverId) {
        return reimbursementDao.selectAllByResolver(resolverId);
    }

    @Override
    public List<Reimbursement> getAllByStatus(int status) {
        return reimbursementDao.selectAllReimbursementsByStatus(status);
    }

    @Override
    public List<Reimbursement> getAll() {
        return reimbursementDao.selectAllReimbursements();
    }

    @Override
    public List<Reimbursement> getAllByUserId(int userId) {
        return reimbursementDao.selectAllReimbursementsById(userId);
    }

    @Override
    public Reimbursement getById(int reimbId) {
        return null;
    }

    @Override
    public boolean submitReimbursement(Reimbursement reimbursement) {
        return reimbursementDao.insertReimbursement(reimbursement);
    }

    @Override
    public boolean updateReimbursement(int Id, int status) {
        return reimbursementDao.updateReimbursement(Id, status);
    }

    public static void main(String[] args) {
        ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();
        reimbursementDao.updateReimbursement(10,2);
//        Timestamp dateSubmitted = new Timestamp(System.currentTimeMillis());
        Reimbursement reimbursement = new Reimbursement(1,"Snickers", 11, 4);

        ReimbursementService reimbursementService = new ReimbursementServiceImpl();
//        reimbursementService.updateReimbursement(9, 4, 3);
//        reimbursementService.getAllByResolver(4);
        reimbursementService.submitReimbursement(reimbursement);
//        System.out.println(reimbursementDao.selectAllReimbursementsByStatus(2));
    }
}
