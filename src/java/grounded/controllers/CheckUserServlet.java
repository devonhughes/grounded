package grounded.controllers;

import grounded.business.User;
import grounded.data.UserDB;
import grounded.util.CookieUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet 
public class CheckUserServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get current action from settings page
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "checkUser";  
        }
        String url = "/ProperlyAndTrulyFucked.jsp";
        if(action.equals("checkUser")) {
            System.out.println("nope we dont fit in this hoal");
            //check session ID's user object to see if userID exists in db
            HttpSession session = request.getSession();
            
            
            if (session.getAttribute("user") != null){
                User user = (User) session.getAttribute("user");
                url = "/appSettings";
                System.out.println("url: " + url + " user:" + user.toString());
            
            } else {
            // if the User object doesn't exist, check for the email cookie
            Cookie[] cookies = request.getCookies();
            String userID =
                    CookieUtil.getCookieValue(cookies, "userIDCookie");
            
	    // if the email cookie doesn't exist, create new user account
            if (userID == null || userID.equals("")) {
                url = "/account.jsp";
            } else {
                User user = UserDB.selectUser(userID);
                // if a user for that ID isn't in the database, 
                // go to the create account page
                if (user == null) {
                    url = "/account.jsp";
                }
                session.setAttribute("user", user);
            }
        }
        

        // forward request to updates JSP
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

  }
}

