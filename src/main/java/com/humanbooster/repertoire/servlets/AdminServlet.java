/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.repertoire.servlets;

import com.humanbooster.repertoire.models.Users;
import com.humanbooster.repertoire.services.UsersService;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author HB
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
@MultipartConfig(
        fileSizeThreshold   = 5242880,
        maxFileSize         = 10485760, 
        maxRequestSize      = 20971520
)
public class AdminServlet extends HttpServlet {

    private UsersService usersService;
    private HttpSession session;

    public AdminServlet() {
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
        
        request.getRequestDispatcher("admin.jsp").forward(request, response);
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
        String date_hire = request.getParameter("date_hire");
        String cellphone_number = request.getParameter("cellphone");
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
        boolean isAdmin = false;
        
        if(request.getParameter("isAdmin") != null){
            isAdmin = true;
        }
         
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + "uploads";


        File uploadFolder = new File(uploadFilePath);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        String uniqueID = UUID.randomUUID().toString();
        String filePath = uploadFilePath + File.separator + uniqueID +".jpg";


        // write all files in upload folder
        for (Part part : request.getParts()) {
            if (part != null && part.getSize() > 0) {


                part.write(filePath);
            }
        }
        
        Users user = new Users(filePath, name, firstName, date_hire, cellphone_number, isAdmin);
        
        try {
            usersService.createUser(user, login, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
