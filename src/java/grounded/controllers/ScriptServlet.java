package grounded.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScriptServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        //set message
        String message = request.getParameter("message");
        message = setMessage(message);
        
      if (request.getParameter("selectApp").equals("minecraft") ) {
		String programName = "minecraft";   
                String bashName = "minecraft-pi";
		String logPath = "var/log/mLog";
                writeScript(request, response, programName, bashName, logPath, message);
      }
      //SCRATCH SCRIPT
      if (request.getParameter("selectApp").equals("scratch") ) {
        	String programName = "scratch";
                String bashName = "scratch-pi"; 
		String logPath = "var/log/sLog";
                writeScript(request, response, programName, bashName, logPath, message);
      }
      //BROWSER SCRIPT        
            if (request.getParameter("selectApp").equals("firefox") ) {
        	String programName = "firefox";
                String bashName = "firefox-bin"; 
		String logPath = "var/log/bLog";  
                writeScript(request, response, programName, bashName, logPath, message);
      }        
    } 

    public String setMessage(String m){
            
            switch (m) {
                case "restricted":
                m = "Access\\ restricted.";
                break;
                case "bedtime":
                m = "Go\\ to \\ bed!";
                break;
                case "warning":
                m = "This\\ attempt\\ has\\ been\\ logged.\\ "
                       + "After\\ 3\\ attempts\\ you\\ will\\ be\\ grounded!";   
                break;
             }
            return m;
    }
    private String generateTimeRange(String programName, String timerange, String logpath, String message){
        String superChunk = "";
        Hashtable startTimes = new Hashtable();
        startTimes.put("graveyard", "00");
        startTimes.put("early", "6");
        startTimes.put("brunch", "9");
        startTimes.put("lunch", "12");
        startTimes.put("afternoon", "15");
        startTimes.put("evening", "18");
        startTimes.put("night", "21");
        String startTime = (String) startTimes.get(timerange);
        
        Hashtable endTimes = new Hashtable();   //is nigh REPENT
        endTimes.put("graveyard", "6");
        endTimes.put("early", "9");
        endTimes.put("brunch", "12");
        endTimes.put("lunch", "15");
        endTimes.put("afternoon", "18");
        endTimes.put("evening", "21");
        endTimes.put("night", "00");
        String endTime = (String) endTimes.get(timerange);
        
        superChunk += " if [ $(date +%H) -gt " + startTime + " ] "
                + "&& [ $(date +%H) -lt " + endTime + " ]; then \n"
	+ " scriptTest = 1; \n echo \"failed " + programName + " attempt at \" $(date) >> "+ logpath +" \n";
        if (!(message == null)){ 
            superChunk += " zenity --warning --text=" + message +"\n";
	}
       
        superChunk += "fi";
        return superChunk;
    }

   public void writeScript(HttpServletRequest request, HttpServletResponse response, 
                        String programName, String bashName, String logPath, String message ) throws FileNotFoundException{
       
        //to print dynamically to create script texts
        File file = new File (programName);
        file.getParentFile().mkdirs();
        try (PrintWriter printWriter = new PrintWriter (programName)) {
            //print lines to file and set correct times to limit use
            printWriter.println (" #!/bin/bash " );
            String[] timeRanges = {"graveyard", "early", "brunch", "lunch", "afternoon", "evening", "night"};
            for (String timeRange : timeRanges) {
                if (request.getParameter(timeRange).equals("yes")) {
                    printWriter.println (generateTimeRange(programName, timeRange, logPath, message) );
                }
            }
            
            printWriter.println (" if [ $scriptTest -eq 0 ] ; then ");
            
                
            //print end of script
                printWriter.println(" echo \"successful firefox attempt at \" $(date) >> /var/log/bLog " 
				+ " killall " + bashName + "; " 
				+ " /usr/bin/" + bashName + "& ; fi; " );
			
		printWriter.close ();  
            }
    } 
}



