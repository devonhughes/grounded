package grounded.controllers;

import grounded.business.Log;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class LogServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "showLog";  // return to log page
        }

	// perform action and set URL to appropriate page
        if(action.equals("showLog")) {
                   
            String url = "/logs.jsp";
            System.out.println("url is now: " + url);
            //get values from request
            String selectLog = request.getParameter("selectLog"); //minecraft log
        
	// process paramters
            // if no selection made, reload monitor page
        if (selectLog == null) {
            url ="/logs.jsp";
        } 
        
        //create Log object and set values
        Log log = new Log();     
        log.setMinecraftLog(mLog);
        log.setScratchLog(sLog);
        log.setBrowserLog(bLog);
           
        //store settings object in request
        request.setAttribute("log", log);
        System.out.println("url is now: " + url);
        // forward request to updates JSP
            getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        }   
    }
    
    public void displayLog(String log){
        System.out.println("displayLog(): " + log);
    }
    