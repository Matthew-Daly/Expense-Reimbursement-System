package dao;

import model.Reimbursement;

import java.sql.Timestamp;
import java.util.List;

public interface ReimbursementDao {

    public Boolean insertReimbursement(Reimbursement reimbursement);
    public List<Reimbursement> selectAllReimbursements();
    public List<Reimbursement> selectAllReimbursementsByStatus(int status);
    public List<Reimbursement> selectAllReimbursementsById(int userId);
    public List<Reimbursement> selectAllByResolver(int resolverId);
    public Reimbursement selectReimbursementById(int reimbId);
    public Reimbursement getReimbursementByResolver(int reimbResolver);
    public boolean updateReimbursement(int reimbId, int status);

}
