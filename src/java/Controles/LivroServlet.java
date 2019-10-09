/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOAutor;
import DAOs.DAOEditora;
import DAOs.DAOGenero;
import DAOs.DAOLivro;
import DAOs.DAOLocal;
import Entidades.Autor;
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
@WebServlet(name = "LivroServlet", urlPatterns = {"/LivroServlet"})
public class LivroServlet extends HttpServlet {

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

        DAOLivro daoLivro = new DAOLivro();
        DAOEditora daoEditora = new DAOEditora();
        DAOAutor daoAutor = new DAOAutor();
        DAOLocal daoLocal = new DAOLocal();
        DAOGenero daoGenero = new DAOGenero();

        List<Livro> l = daoLivro.listInOrderId();
        List<Editora> editoras = daoEditora.listInOrderId();
        List<Autor> autores = daoAutor.listInOrderId();
        List<Local> locais = daoLocal.listInOrderId();
        List<Genero> generos = daoGenero.listInOrderId();

        int id = daoLivro.autoIdLivro();
        String titulo = request.getParameter("titulo");
        String qt = request.getParameter("qt");
        String autor = request.getParameter("autor");
        String local = request.getParameter("local");
        String genero = request.getParameter("gen");
        String editora = request.getParameter("edit");
        String data = request.getParameter("dt");

        String e1 = request.getParameter("edit");
        String a1 = request.getParameter("autor");
        String l1 = request.getParameter("local");
        String g1 = request.getParameter("gen");
        System.out.println(e1 + a1 + l1 + g1);

        Livro livro = new Livro();

        livro.setIdLivro(id);
        livro.setNomeLivro(titulo);
        try {
            livro.setDataLancamento(new SimpleDateFormat("dd/MM/yyyy").parse(data));
        } catch (ParseException ex) {
        }
        Autor aV = null;
        Genero gV = null;
        Editora eV = null;
        Local lV = null;
        for (Genero g : generos) {
            System.out.println(g1 + " aAAAAAAAAAAAAA");
            System.out.println(g.getGenero() + " bBBBBBBBBBBBBB");
            if (String.valueOf(g.getGenero()).equals(g1)) {
                gV = g;
            }
        }
        for (Autor a : autores) {
            if (String.valueOf(a.getAutor()).equals(a1)) {
                aV = a;
            }
        }
        for (Local ls : locais) {
            if (String.valueOf(ls.getLocal()).equals(l1)) {
                lV = ls;
            }
        }
        for (Editora e : editoras) {
            if (String.valueOf(e.getEditora()).equals(e1)) {
                eV = e;
            }
        }
        System.out.println(aV);
        livro.setAutorIdAutor(aV);
        livro.setEditoraIdEditora(eV);
        livro.setGeneroIdGenero(gV);
        livro.setLocalIdLocal(lV);
        livro.setQuantidade(Integer.parseInt(qt));
        livro.setReservas(0);

        daoLivro.inserir(livro);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LivroServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>id = " + id + "</h1>");
            out.println("<h1>tit = " + titulo + "</h1>");
            out.println("<h1>qt = " + qt + "</h1>");
            out.println("<h1>aut = " + autor + "</h1>");
            out.println("<h1>local = " + local + "</h1>");
            out.println("<h1>gen = " + genero + "</h1>");
            out.println("<h1>editora = " + editora + "</h1>");
            out.println("<h1>date = " + data + "</h1>");
            out.println("<a href=\"cdLivro.jsp\">voltar</a>");
            out.println("</body>");
            out.println("</html>");

            request.setAttribute("Livro", livro);
            request.getRequestDispatcher("cdLivro.jsp").forward(request, response);

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
