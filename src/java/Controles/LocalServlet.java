/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOLocal;
import DAOs.DAOEditora;
import DAOs.DAOGenero;
import DAOs.DAOLivro;
import DAOs.DAOLocal;
import Entidades.Local;
import Entidades.Editora;
import Entidades.Genero;
import Entidades.Livro;
import Entidades.Local;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João Otavio
 */
@WebServlet(name = "LocalServlet", urlPatterns = {"/LocalServlet"})
public class LocalServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DAOLocal daoLocal = new DAOLocal();

        int id = daoLocal.autoIdLocal();
        String nome = request.getParameter("nome");

        Local local = new Local();

        local.setIdLocal(id);
        local.setLocal(nome);
        
        daoLocal.inserir(local);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LocalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>id = " + id + "</h1>");
            out.println("<h1>tit = " + nome + "</h1>");
            out.println("<a href=\"cdLivro.jsp\">voltar</a>");
            out.println("</body>");
            out.println("</html>");

            request.setAttribute("Local", local);
            request.getRequestDispatcher("cdLocal.jsp").forward(request, response);

        }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
