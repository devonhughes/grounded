<%@ include file="includes/header.html" %>
<%@ include file="includes/navs.html" %>

<div id="mainBody">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4>Hello <!-- ${user.userID} -->, Select which services you would like to limit:</h4>           
    <form class action="checkUser" method="post">
        <input type="hidden" name="action" value="checkUser">
        <input type="radio" name="selectApp" value="minecraft"> minecraft<br>
        <input type="radio" name="selectApp" value="scratch"> scratch<br>
	<input type="radio" name="selectApp" value="browser"> browser<br>

    <h4>Select the times to restrict access</h4>
            <table style="width:100%">
            <tr>
                <td><input type="checkbox" name="graveyard" value="yes"> Midnight - 6am</td>
                <td><input type="checkbox" name="afternoon" value="yes"> 3pm - 6pm</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="early" value="yes"> 6am - 9am  </td>
                <td><input type="checkbox" name="evening" value="yes"> 6pm - 9pm</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="brunch" value="yes"> 9am - noon </td>
                <td><input type="checkbox" name="night" value="yes"> 9pm - midnight</td>
            </tr>
            <tr><td><input type="checkbox" name="lunch" value="yes"> noon - 3pm</td></tr>
            </table>      
                        
    <h4>Set a custom message</h4>
        <input type="radio" name="message" value="null"> none<br>
        <input type="radio" name="message" value="restricted"> Access restricted.<br>
        <input type="radio" name="message" value="bedtime"> Go to bed!<br>
        <input type="radio" name="message" value="warning"> This attempt has been logged. 
                    After 3 attempts you will be grounded!<br>
                
        <input type="checkbox" name="time" value="yes"> Read message using text to speech <br><br>                                                        
        <input type="submit" value="Submit" >  
    </form>
</div>    
             
<%@ include file="includes/footer.html" %>
		
		
	
			