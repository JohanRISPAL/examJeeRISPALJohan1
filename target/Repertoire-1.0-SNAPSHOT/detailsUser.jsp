<%-- 
    Document   : detailsUser
    Created on : 28 janv. 2021, 14:36:39
    Author     : HB
--%>

<%@page import="com.humanbooster.repertoire.models.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="/css/navbar.css"%></style>
        <style><%@include file="/css/detailsUser.css"%></style>
        <title>Détails utilisateur</title>
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
        
        
        <%
            Users user = (Users) request.getAttribute("user");
        %>
        
        <h1><%=user.getFirstName()%> <%=user.getName()%></h1>
        <img src="<%=user.getImage_link()%>">
        <div id="informationUser">
            <p>Date d'embauche : <%=user.getDate_hire()%></p>
            <p>Numéro de téléphone : <%=user.getCellphone_number()%></p>
            <%
                if (user.isIsAdmin() == false) {
                %>
                <p>Role : Employé</p>
                <%
                    }else{
                %>
                <p>Role : Admin</p>
                <%
                }
            %>
        </div>
    </body>
</html>
