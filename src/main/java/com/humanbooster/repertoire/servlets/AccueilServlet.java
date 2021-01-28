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
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "AccueilServlet", urlPatterns = {"/accueil"})
public class AccueilServlet extends HttpServlet {

    private UsersService usersService;
    private HttpSession session;

    public AccueilServlet() {
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
        
        ArrayList<Users> users =new ArrayList<>();

        try {
            users = this.usersService.getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("users", users);

        request.getRequestDispatcher("accueil.jsp").forward(request, response);
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
        
        String userId = request.getParameter("userId");
        Integer id = Integer.parseInt(userId);
        
        try {
            usersService.deleteUser(id);
        } catch (SQLException ex) {
            Logger.getLogger(AccueilServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.doGet(request, response);
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
