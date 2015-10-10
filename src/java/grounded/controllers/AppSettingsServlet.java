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


@WebServlet
public class AppSettingsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "appSettings";  // return to settings page
        }
        // perform action and set URL to appropriate page
        
        if(action.equals("appSettings")) {
            String url = "";
            // see if user exists in db or not
            url = checkUser(request, response); 
            
            //if user exists...run code below
            if(url.equals("settings.jsp")){
                //get values from request
                String app = request.getParameter("selectApp");
                String message = request.getParameter("message");           
                String graveyard = request.getParameter("graveyard");
                String early = request.getParameter("early");
                String brunch = request.getParameter("brunch");
                String lunch = request.getParameter("lunch");
                String afternoon = request.getParameter("afternoon");
                String evening = request.getParameter("evening");
                String night = request.getParameter("night");
            
                //create Settings object and set values
                Settings settings = new Settings();     
                settings.setAppType(app);
                settings.setCustomMessage(message);
                settings.setGraveyard(graveyard);
                settings.setEarly(early);
                settings.setBrunch(brunch);
                settings.setLunch(lunch);
                settings.setAfternoon(afternoon);
                settings.setEvening(evening);
                settings.setNight(night);
                System.out.println(message);
                
                //store settings object in request
                request.setAttribute("settings", settings);
            }
            //else forward request to url="/account.jsp";
            else if(url.equals("/account.jsp")){
                action = "newUser";
                request.setAttribute("url", url);
                request.setAttribute("action", action);
                
            } 
            //else {            }
            //url = "/updates.jsp";
            
            
            
            /* test print for values: yes or null = success
            System.out.println("Time range values: \n");
            System.out.println("Graveyard: " + graveyard);
            System.out.println("early: " + early);
            System.out.println("brunch: " + brunch);
            System.out.println("lunch: " + lunch);
            System.out.println("afternoon: " + afternoon);
            System.out.println("evening: " + evening);
            System.out.println("night: " + night); */
           


            // forward request to updates JSP
            getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            
            }
    }

    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/account.jsp";
        
       String action = request.getParameter("action");
        
        // perform action and set URL to appropriate page
        url = "settings";
        if (action.equals("newUser")) {
            url = "registerUser";
        }  
        
        

        // forward to the view
        getServletContext() 
                .getRequestDispatcher(url)
                .forward(request, response);
        } 
    
    private String checkUser(HttpServletRequest request,
            HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // if the User object exists with userID, skip User page
        String url = "/account.jsp";

        if (user != null && !user.getUserID().equals("")) {
            url = "/settings.jsp";
        } else {  // otherwise, check the email cookie
            Cookie[] cookies = request.getCookies();
            String userID
                    = CookieUtil.getCookieValue(cookies, "userIDCookie");
            if (userID.equals("")) {
                user = new User();
                url = "/account.jsp";
            } else {
                user  = UserDB.selectUser(userID);
                if (user != null && !user.getUserID().equals("")) {
                    url = "/settings.jsp";
                }
            }
        }
        session.setAttribute("user", user);
        return url;
    }
   
    private String registerUser(HttpServletRequest request,
            HttpServletResponse response) {

        // get the user data
        String userID = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // store the data in a User object
        User user = new User();
        user.setUserID(userID);
        user.setPassword(password);
        user.setEmail(email);
        
        // write the User object to a file
//        ServletContext sc = getServletContext();
//        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
//        UserIO.add(user, path);

        // store the User object as a session attribute
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // add a cookie that stores the user's email as a cookie
        Cookie c1 = new Cookie("emailCookie", email);
        c1.setMaxAge(60 * 60 * 24 * 365 * 2); // set age to 2 years
        c1.setPath("/");                      // allow entire app to access it
        response.addCookie(c1);

        // add a cookie that stores the userID as a cookie
        Cookie c2 = new Cookie("userIDCookie", userID);
        c2.setMaxAge(60 * 60 * 24 * 365 * 2); // set age to 2 years
        c2.setPath("/");                      // allow entire app to access it
        response.addCookie(c2);

        // create and return a URL for the appropriate Download page
        String productCode = (String) session.getAttribute("productCode");
        String url = "/" + productCode + "_download.jsp";
        return url;
    }

    private String deleteCookies(HttpServletRequest request,
            HttpServletResponse response) {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0); //delete the cookie
            cookie.setPath("/"); //allow the download application to access it
            response.addCookie(cookie);
        }
        String url = "/delete_cookies.jsp";
        return url;
    }

   
    }

   