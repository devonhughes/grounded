<%@ include file="includes/header.html" %>
<%@ include file="includes/navs.html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 the ${settings.appType} settings were updated:
    <br><br>
    
        <c:if test="${settings.graveyard == 'yes'}">
            <label>12am - 6am: Restricted</label><br>
        </c:if>
        <c:if test="${settings.early == 'yes'}">
            <label>6am - 9am: &nbsp; Restricted</label><br>
        </c:if>
        <c:if test="${settings.brunch == 'yes'}">
            <label>9am - 12am: Restricted</label><br>
        </c:if>
        <c:if test="${settings.lunch  == 'yes'}">
            <label>12pm - 3pm: Restricted</label><br>
        </c:if>
        <c:if test="${settings.afternoon == 'yes'}">
            <label>3pm - 6pm: &nbsp;  Restricted</label><br>
        </c:if>
        <c:if test="${settings.evening == 'yes'}">
            <label>6pm - 9pm: &nbsp;  Restricted</label><br>
        </c:if>
        <c:if test="${settings.night == 'yes'}">
            <label>9pm - 12am: Restricted</label><br>
        </c:if>
    <br>

    <label>custom message:</label><br>
    <span>${settings.customMessage}</span><br>
   


<%@ include file="includes/footer.html" %>