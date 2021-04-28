package frontcontroller;

import controller.ReimbursementController;
import controller.UserController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Dispatcher {

    UserController user;
    ReimbursementController reimbursement;

    public Dispatcher(Javalin app){

        app.routes(() -> {
            path("/api/user", () -> {
                post(UserController::login);
                path("id", () ->{
                    get(UserController::getUserById);
                });
                path("checksession", () -> {
                    get(UserController::checkSession);
                });
                path("/name/:authorId", () -> {
                    get((UserController::getFullName));
                });
            });
            path("/api/reimbursements", ()-> {
                get(ReimbursementController::getAllReimbursements);
                path("/status/:status", ()-> {
                    get(ReimbursementController::getAllByStatus);
                    });
                path("/emp/:id", ()-> {
                       get(ReimbursementController::getReimbursementById);
                });
                path("/:id/:status", ()->{
                    patch(ReimbursementController::updateReimbursement);
                });
                path("/submit", ()-> {
                   post(ReimbursementController::submitReimbursement);
                });
            });
        });

        app.get("/logout", UserController::logout);
    }

}
