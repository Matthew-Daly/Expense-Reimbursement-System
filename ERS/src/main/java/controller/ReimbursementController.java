package controller;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import io.javalin.Javalin;
import io.javalin.http.Context;
import model.Reimbursement;
import model.User;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;

public class ReimbursementController {

    static ReimbursementService reimbursementService = new ReimbursementServiceImpl();

    Javalin app;


    //constructor
    public ReimbursementController(Javalin app){
        this.app = app;

        app.get("/api/reimbursements/", ReimbursementController::getAllReimbursements);
        app.get("/api/reimbursements/:id",ReimbursementController::getReimbursementById);
        app.get("/api/reimbursements/:id/:status", ReimbursementController::updateReimbursement);
        app.get("api/reimbursements/:status", ReimbursementController::getAllByStatus);
    }


    //routes
    public static void getAllReimbursements(Context context){
        context.json(reimbursementService.getAll());
    }

    public static void getReimbursementById(Context context){
        int reimId = Integer.parseInt(context.pathParam("id"));
        context.json(reimbursementService.getAllByUserId(reimId));
    }

    public static void updateReimbursement(Context context){
        int status = Integer.parseInt(context.pathParam("status"));
        System.out.println(status);
        int reimId = Integer.parseInt(context.pathParam("id"));
        System.out.println(reimId);

        context.json(reimbursementService.updateReimbursement(reimId, status));
    }

    public static void getAllByStatus(Context context){
        int status = Integer.parseInt(context.pathParam("status"));
        context.json(reimbursementService.getAllByStatus(status));
    }


    public void submitReimbursementTwo(Reimbursement reimbursement){
        reimbursementService.submitReimbursement(reimbursement);
    }

    public static void submitReimbursement(Context context){
        User user = context.sessionAttribute("currentUser");
        Double amount = Double.parseDouble(context.formParam("amount"));
        String description = context.formParam("description");
        int typeId = Integer.parseInt(context.formParam("typeId"));

        Reimbursement reimbursement = new Reimbursement(amount, description, user.getUserId(), typeId);
        reimbursementService.submitReimbursement(reimbursement);

        context.redirect("/employee.html");
    }

}
