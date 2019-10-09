/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOLivro;
import DAOs.DAOUsuario;
import Entidades.Usuario;
import Entidades.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jdt.internal.compiler.batch.Main;

/**
 *
 * @author João Otavio
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuario"})
public class UsuarioServlet extends HttpServlet {

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

        DAOUsuario daoUsuario = new DAOUsuario();
        List<Usuario> usuarios = daoUsuario.listInOrderId();
        Usuario usuario = new Usuario();

        String acao = daoUsuario.getAcao();
   
        switch (acao) {            
            case "inserindo":
                int id = daoUsuario.autoIdUsuario();
                String usu = request.getParameter("usu");
                String senha = request.getParameter("senha");
                String nome = request.getParameter("nome");
                String sexo = request.getParameter("sexo");
                String data = request.getParameter("data");
                String cpf = request.getParameter("cpf");
                String end = request.getParameter("end");
                String tel = request.getParameter("tel");
                String email = request.getParameter("email");

                usuario.setIdUsuario(id);
                usuario.setSenha(senha);
                usuario.setNome(nome);
                usuario.setSexo(sexo);
                try {
                    usuario.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(data));
                } catch (ParseException ex) {
                }
                usuario.setCpf(cpf);
                usuario.setEndereco(end);
                usuario.setTelefone(tel);
                usuario.setEmail(email);
                usuario.setLivrosAlugados(0);

                daoUsuario.inserir(usuario);
                request.setAttribute("Usuario", usuario);
                request.getRequestDispatcher("login.jsp").forward(request, response);

                break;

            case "logando":
                String eL = request.getParameter("email");
                String sN = request.getParameter("pass");
                int ax = 0;
                for (Usuario u : usuarios) {
                    if (u.getEmail().equals(eL) && u.getSenha().equals(sN)) {
                        daoUsuario.setIdLogado(u.getIdUsuario());
                        usuario.setIdUsuario(u.getIdUsuario());
                        usuario.setSenha(u.getSenha());
                        usuario.setNome(u.getNome());
                        usuario.setSexo(u.getSexo());
                        usuario.setDataNascimento(u.getDataNascimento());
                        usuario.setCpf(u.getCpf());
                        usuario.setEndereco(u.getEndereco());
                        usuario.setTelefone(u.getTelefone());
                        usuario.setEmail(u.getEmail());
                        usuario.setLivrosAlugados(u.getLivrosAlugados());
                        System.out.println(usuario.getNome());
                        request.setAttribute("Usuario", usuario);
                        request.setAttribute("UsuarioNome", u.getNome());
                        request.getRequestDispatcher("system.jsp").forward(request, response);
                        ax = 1;
                    }
                }
                if (ax == 0) {
                    request.setAttribute("loginError",1);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                break;

        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

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
