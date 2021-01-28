<%-- 
    Document   : admin
    Created on : 28 janv. 2021, 10:20:40
    Author     : HB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="/css/navbar.css"%></style>
        <style><%@include file="/css/admin.css"%></style>
        <title>Administration</title>
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
        
        <h1>Création d'un utilisateur</h1>
        
        <form method="post" enctype="multipart/form-data">
            <div id="fields">
                <label>Nom : </label>
                <input type="text" placeholder="Entrer votre nom" name="name" required>
            </div>
            
            <div id="fields">
                <label>Prénom : </label>
                <input type="text" placeholder="Entrer votre nom" name="firstName" required>
            </div>
            
            <div id="fields">
                <label>Date d'embauche : </label>
                <input type="date" name="date_hire" required>
            </div>
            
            <div id="fields">
                <label>Numéro de téléphone : </label>
                <input type="text" placeholder="Entrer votre numéro de téléphone" name="cellphone" maxlength="10" required>
            </div>
            
            <div id="fields">
                <label>Login : </label>
                <input type="text" placeholder="Entrer votre login" name="login" required>
            </div>
            
            <div id="fields">
                <label>Mot de passe : </label>
                <input type="text" placeholder="Entrer votre mot de passe" name="pwd" required>
            </div>
            
            <div id="fields">
                <label for="image">Image à upload</label>
                <input type="file" accept="image/jpeg" class="form-control" id="image" name="image" placeholder="Veuillez upload un fichier">
            </div>
            
            <div id="fields">
                <label>Utilisateur admin</label>
                <input type="checkbox" name="isAdmin">
            </div> 
            
            <div id="fields">
                <input type="submit" value="Créer !">
            </div>
        </form>
    </body>
</html>
