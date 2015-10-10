package grounded.controllers;

import grounded.business.Settings;
import grounded.business.User;
import grounded.data.UserDB;
import grounded.util.CookieUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Primary
 */
@WebServlet
public class AccountServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        String url = "";
        // get current action from createAccount page
        String action = request.getParameter("action");
        if( action == null || action.equals("")){
            action = "newUser";
        }
        if (action == null) {
            url="account.jsp";  
        }
        
        
            
        //create new account
        if(action.equals("newUser")) {
            
            //get user info
            String userID = request.getParameter("userID");
            String email = request.getParameter("email"); 
            String password = request.getParameter("password");
            
            //create user object
            User user = new User();            
            user.setUserID(userID);
            user.setEmail(email);
            user.setPassword(password);
            
            System.out.println("is my user ID = " + userID);
            //add user to db
            UserDB.insert(user);
            
            //store user in session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            //add cookie to store userID in browser
            Cookie c = new Cookie("userIDCookie", userID);
            c.setMaxAge(60*60*24*365*2);
            c.setPath("/");
            response.addCookie(c);

            request.setAttribute("user", user);
            url = "settings.jsp";
            
        } else {   
            //login user 
        if(action.equals("login")) {
            User user = new User();
            String userID = request.getParameter("userID");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            UserDB.selectUser(userID);
        }
        
        Cookie[] cookies = request.getCookies();
        String userIDcookie = CookieUtil.getCookieValue(cookies, "userIDCookie");
        
    getServletContext()
            .getRequestDispatcher(url)
            .forward(request,response);    
    } 
        
        
    }   
    

}