/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOEditora;
import DAOs.DAOEditora;
import DAOs.DAOGenero;
import DAOs.DAOLivro;
import DAOs.DAOLocal;
import Entidades.Editora;
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
@WebServlet(name = "EditoraServlet", urlPatterns = {"/EditoraServlet"})
public class EditoraServlet extends HttpServlet {

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

        DAOEditora daoEditora = new DAOEditora();

        int id = daoEditora.autoIdEditora();
        String nome = request.getParameter("nome");

        Editora editora = new Editora();

        editora.setIdEditora(id);
        editora.setEditora(nome);
        
        daoEditora.inserir(editora);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditoraServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>id = " + id + "</h1>");
            out.println("<h1>tit = " + nome + "</h1>");
            out.println("<a href=\"cdLivro.jsp\">voltar</a>");
            out.println("</body>");
            out.println("</html>");

            request.setAttribute("Editora", editora);
            request.getRequestDispatcher("cdEditora.jsp").forward(request, response);

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
