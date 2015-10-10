<%@ include file="includes/header.html" %>
<%@ include file="includes/navs.html" %>
			
<div id="mainBody">
<h4>Select the log you would like to view: </h4>
               
    <form class action="showLog" method="post">
        <input type="radio" name="selectLog" value="minecraft"> minecraft log<br>
  	<input type="radio" name="selectLog" value="scratch"> scratch log<br>
        <input type="radio" name="selectLog" value="browser"> browser log<br><br>
                 
        <input type="submit" value="Submit" class="margin_left">  
    </form>
</div>

<%@ include file="includes/footer.html" %>
