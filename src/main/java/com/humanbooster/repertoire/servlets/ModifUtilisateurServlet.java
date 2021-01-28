/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.repertoire.servlets;

import com.humanbooster.repertoire.models.Users;
import com.humanbooster.repertoire.services.UsersService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HB
 */
@WebServlet(name = "ModifUtilisateurServlet", urlPatterns = {"/modifUser"})
public class ModifUtilisateurServlet extends HttpServlet {

    private UsersService usersService;
    private HttpSession session;

    public ModifUtilisateurServlet() {
        this.usersService = new UsersService();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String id = request.getParameter("userId");
        
        Users userSelected = null;
        
        try {
            userSelected = usersService.getUserById(id);
        } catch (SQLException ex) {
            Logger.getLogger(DetailsUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("user", userSelected);
        
        request.getRequestDispatcher("modifUser.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String firstName = request.getParameter("firstName");
        String date = request.getParameter("dateHire");
        String cellphone = request.getParameter("cellphone");
        
        String id = request.getParameter("userId");
        
        try {
            usersService.updateUser(name, firstName, date, cellphone, id);
        } catch (SQLException ex) {
            Logger.getLogger(ModifUtilisateurServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect(request.getContextPath() + "/accueil");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
