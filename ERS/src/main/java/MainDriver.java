import frontcontroller.FrontController;
import io.javalin.Javalin;


public class MainDriver {
    public static void main(String[] args) {

        Javalin app = Javalin.create(
                config -> {
                    config.addStaticFiles("/views");
                }
        ).start(9002);
        FrontController frontController = new FrontController(app);

    }
}



