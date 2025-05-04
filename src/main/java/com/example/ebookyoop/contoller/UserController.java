package com.example.ebookyoop.contoller;

import com.example.ebookyoop.service.BookService;
import jakarta.servlet.http.HttpSession;
import com.example.ebookyoop.model.User;
import com.example.ebookyoop.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService service;

    public UserController(){
        service = new UserService();
    }

//    Register new User
    @PostMapping("/register-user")
    public String register(@RequestParam("firstname") String firstname,
                            @RequestParam("lastname") String lastname,
                            @RequestParam("idnumber") String idnumber,
                            @RequestParam("email") String email,
                            @RequestParam("password") String password){

        try{
            User user = new User(firstname,lastname,email,password,idnumber);
            service.saveUser(user);
            return "redirect:/login";
        }
        catch (Exception ex){
            return "index";
        }
    }

    @PostMapping("/login-user")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            HttpSession session){
        try{
            User currentUser = service.findUser(email,password);
            if (currentUser != null){
                session.setAttribute("user",currentUser);
                return "redirect:/";
            }else {
                return "redirect:/login?error=true";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return "redirect:/login?error=true";
        }
    }
}
