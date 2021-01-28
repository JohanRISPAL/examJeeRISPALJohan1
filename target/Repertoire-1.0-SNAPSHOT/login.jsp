<%-- 
    Document   : login
    Created on : 28 janv. 2021, 09:44:35
    Author     : HB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="/css/login.css"%></style>
        <title>Login</title>
    </head>
    <body>
        <div class="layout">
            <h1>Connexion</h1>

            <div class="fieldsContainer">
                <form method="post">
                    <label><b>Login</b></label>
                    <input type="text" placeholder="Entrer votre login" name="login" required>

                    <label><b>Password</b></label>
                    <input type="password" placeholder="Entrer votre mot de passe" name="password" required>

                    <input id="submit" type="submit" value="Se connecter !">
                </form>
            </div>
        </div>
    </body>
</html>
