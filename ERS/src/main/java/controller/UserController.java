package controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import model.User;
import service.UserService;
import service.UserServiceImpl;

import static io.javalin.apibuilder.ApiBuilder.*;


public class UserController {
    static UserService userService = new UserServiceImpl();

    Javalin app;


    //constructor
    public UserController(){

    }

    //routes
    public static void getAllUsers(Context context){
        context.json(userService.getAll());
    }


    public static void getFullName(Context context){
        int authorId = Integer.parseInt(context.pathParam("authorId"));
        context.json(userService.getUserName(authorId));
    }

    public static void getUserById(Context context){
        int userId = Integer.parseInt(context.pathParam("id"));
        context.json(userService.getUserById(userId));
    }

    public static void login(Context context){
        User user = context.bodyAsClass(User.class);
        User tempUser = userService.validateLogin(user.getUserName(), user.getPassword());

        if(tempUser != null && tempUser.getRoleId() < 5){
            context.sessionAttribute("currentUser", tempUser);
            context.redirect("/manager.html");
        } else if (tempUser != null && tempUser.getRoleId() >= 5) {
            context.sessionAttribute("currentUser", tempUser);
            context.redirect("/employee.html");
        } else {
            context.json("Invalid login");
            context.sessionAttribute("LoginInResult", "Invalid login");
            context.redirect("/index.html");
        }
        checkSession(context);

    }


    public static void logout(Context context){
        context.sessionAttribute("username", null);
        context.redirect("/index.html");
    }

    public static void checkSession(Context context){
        User user = context.sessionAttribute("currentUser");
        context.json(user);
    }




}
