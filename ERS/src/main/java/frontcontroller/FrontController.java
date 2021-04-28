package frontcontroller;


import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.UnauthorizedResponse;

public class FrontController {
    Javalin app;
    Dispatcher dispatcher;


    public FrontController(Javalin app){
        this.app = app;

        dispatcher = new Dispatcher(app);
    }


}
