<%-- 
    Document   : modifUser
    Created on : 28 janv. 2021, 14:39:03
    Author     : HB
--%>

<%@page import="com.humanbooster.repertoire.models.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="/css/navbar.css"%></style>
        <style><%@include file="/css/modifUser.css"%></style>
        <title>Modification utilisateur</title>
    </head>
    <body>
        
        <div class="navBar">
            <%
            if (session.getAttribute("isAdmin") != null) {
            %>
            <h4>Administrateur</h4>
            <%
                }else{
            %>
            <h4>Utilisateur</h4>
            <%
            }
            %>
            <a href="<%=application.getContextPath()%>/accueil"><b>Accueil</b></a>
            <%
            if (session.getAttribute("isAdmin") != null) {
            %>
            <a href="<%=application.getContextPath()%>/admin"><b>Administration</b></a>  
            <%
                }
            %>
            <a href="<%=application.getContextPath()%>/deconnection"><b>Déco</b></a>
        </div>
        
        <h1>Modification d'utilisateur</h1>
        
        <%
            Users user = (Users) request.getAttribute("user");
        %>
        
        <form method="post">
            <div id="fieldsCreation">
                <p>Prénom :</p>
                <input type="text" value="<%=user.getFirstName()%>" name="firstName">
            </div>
            
            <div id="fieldsCreation">
                <p>Nom :</p>
                <input type="text" value="<%=user.getName()%>" name="name">
            </div>
            
            <div id="fieldsCreation">
                <p>Date d'embauche :</p>
                <input type="date" value="<%=user.getDate_hire()%>" name="dateHire">
            </div>
            
            <div id="fieldsCreation">
                <p>Numéro de téléphone :</p>
                <input type="text" value="<%=user.getCellphone_number()%>" name="cellphone"> 
            </div>
            
            <div id="fieldsCreation">
                <input type="submit" value="Modifier !">
            </div>
        </form>
    </body>
</html>
