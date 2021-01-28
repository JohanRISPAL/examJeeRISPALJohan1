<%-- 
    Document   : accueil
    Created on : 28 janv. 2021, 09:52:34
    Author     : HB
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="/css/navbar.css"%></style>
        <style><%@include file="/css/accueil.css"%></style>
        <title>Accueil</title>
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
        
        <h1>Liste de tout le personnel</h1>
        <div class="usersContainer">
            <c:forEach var="user" items="${users}">
                <div id="user">
                  <p>${user.name} ${user.firstName}</p>
                  <a href="<%=application.getContextPath()%>/details?userId=${user.id}"><b>Voir le profil</b></a>       
                    <%
                    if (session.getAttribute("isAdmin") != null) {
                    %>
                    <a href="<%=application.getContextPath()%>/modifUser?userId=${user.id}"><b>Modifer l'utilisateur</b></a> 
                    <form method="post">
                        <input type="hidden" name="userId" value="${user.id}">

                        <input type="submit" value="Supprimer !">
                    </form>
                    <%
                        }
                    %>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
