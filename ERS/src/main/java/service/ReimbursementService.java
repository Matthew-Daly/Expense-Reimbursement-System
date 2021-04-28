package service;

import model.Reimbursement;

import java.util.List;

public interface ReimbursementService {
    List<Reimbursement> getAllByResolver(int resolverId);
    List<Reimbursement> getAllByStatus( int status);
    List<Reimbursement> getAll();
    List<Reimbursement> getAllByUserId( int userId);
    Reimbursement getById(int reimbId);
    boolean submitReimbursement(Reimbursement reimbursement);
    boolean updateReimbursement(int Id, int status);


}
