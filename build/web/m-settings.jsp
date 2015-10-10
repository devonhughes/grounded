<%@ include file="includes/header.html" %>
<%@ include file="includes/navs.html" %>

<div id="mainBody">
<br>
    <h4>Check the times you want to block Minecraft access</h4>
            
	<form class action="appSettings" method="post">
            <input type="checkbox" name="graveyard" value="yes"> Midnight - 6am<br>
  	    <input type="checkbox" name="early" value="yes"> 6am - 9am<br>
	    <input type="checkbox" name="brunch" value="yes"> 9am - noon <br>
            <input type="checkbox" name="lunch" value="yes"> noon - 3pm<br>
            <input type="checkbox" name="afternoon" value="yes"> 3pm - 6pm<br>
            <input type="checkbox" name="evening" value="yes"> 6pm - 9pm<br>
            <input type="checkbox" name="night" value="yes"> 9pm - midnight<br>
            <br>
                        
    <h4>The default message says "Access denied." <br>
        Or select a custom message</h4>
        <input type="checkbox" name="none" value="null"> none<br>
        <input type="checkbox" name="bedtime" value="null"> Go to bed!<br>
        <input type="checkbox" name="warning" value="null"> This attempt has been logged. 
                    After 3 attempts you will be grounded!<br>
        <br>
                
        <input type="checkbox" name="time" value="yes"> Read message using text to speech <br><br>                                                        
                    <input type="submit" value="Submit" class="margin_left">  Submit Changes
                </form>
</div>    
             
<%@ include file="includes/footer.html" %>
		
		
	
			