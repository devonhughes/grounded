<%@ include file="includes/header.html" %>
<%@ include file="includes/navs.html" %>

    <script>
    function pass() {
        if (document.forms[0].pwd1.value != document.forms[0].pwd2.value) {
            alert('Your passwords did not match');
            return false;
        }
        return true;
    }
    </script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <br><strong>Login</strong><br>
    <form action="login" method="post">
        Username <br>
        <input type="text" name="username" value="<c:out value='${user.userID}'/>"><br>
        Password <br>
        <input type="password" name="pwd1" 
               required pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
               value="<c:out value='${user.password}'/>"><br>
        <input type="submit" value="Login" >          
    </form>
    <br><strong>Create New Account</strong><br>
    <form action="newUser" onSubmit="pass()" method="post">
            <input type="hidden" name="action" value="newUser">
            Username <br>
            <input type="text" name="userID" value="<c:out value='${user.userID}'/>" ><br/>
            <!--<input type="text" name="UserID" value="<c:out value='${user.userID}'/>"><br>-->
            Email<br>
            <input type="email" placeholder="user@email.com" name="email"
            value="<c:out value='${user.email}'/>" ><br/>
            Password <br>
            <input type="password" name="pwd1" 
                   required pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
                   value="<c:out value='${user.password}'/>" ><br/>
            Confirm Password<br>
            <input type="password" name="pwd2" 
                   required pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"><br>
            <input type="submit" value="Create Account" >  
    </form>
    <br>
    Password requires at least 8 characters containing one uppercase,<br>
    one lowercase, one number and one special character)<br>
    
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <table>
        <tr>
            <th>Name</th>
            <th>Value</th>
        </tr>
        <c:forEach var="c" items="${cookie}">
        <tr>
            <td>${c.value.name}</td>
            <td>${c.value.value}</td>            
        </c:forEach>
    </table>
    
   



<%@ include file="includes/footer.html" %>
