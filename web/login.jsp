<%-- 
    Document   : login
    Created on : 06/05/2019, 15:38:19
    Author     : João Otavio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, 
        DAOs.DAOUsuario ,
        Entidades.Usuario" %>
<%
    DAOUsuario dao = new DAOUsuario();
%>
<%request.getAttribute("loginError");%>
<c:if test="${not empty loginError}">
    <script>
         alert('Login ou senha inválido(a)!');    
    </script>
</c:if>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Tavinho's Library</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
        <!-- endinject -->
        <!-- plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <link rel="stylesheet" href="css/style.css">
        <!-- endinject -->
        <link rel="shortcut icon" href="images/favicon.png" />
    </head>
    <!--Start of Tawk.to Script-->
    <script type="text/javascript">
        var Tawk_API = Tawk_API || {}, Tawk_LoadStart = new Date();
        (function () {
            var s1 = document.createElement("script"), s0 = document.getElementsByTagName("script")[0];
            s1.async = true;
            s1.src = 'https://embed.tawk.to/5cd984782846b90c57ae4524/default';
            s1.charset = 'UTF-8';
            s1.setAttribute('crossorigin', '*');
            s0.parentNode.insertBefore(s1, s0);
        })();
    </script>
    <!--End of Tawk.to Script-->

    <body>
        <div class="container-scroller">
            <div class="container-fluid page-body-wrapper full-page-wrapper auth-page">
                <div class="content-wrapper d-flex align-items-center auth auth-bg-1 theme-one">
                    <div class="row w-100">
                        <div class="col-lg-4 mx-auto">
                            <div class="auto-form-wrapper">
                                <form action="${pageContext.request.contextPath}/usuario">
                                    <% 
                                        dao.setAcao("logando");
                                    %>
                                    <div class="form-group">
                                        <label class="label">Email</label>
                                        <div class="input-group">
                                            <input name="email" type="text" class="form-control" placeholder="Email">
                                            <div class="input-group-append">
                                                <span class="input-group-text">
                                                    <i class="mdi mdi-check-circle-outline"></i>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="label">Senha</label>
                                        <div class="input-group">
                                            <input name="pass" type="password" class="form-control" placeholder="*********">
                                            <div class="input-group-append">
                                                <span class="input-group-text">
                                                    <i class="mdi mdi-check-circle-outline"></i>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary submit-btn btn-block" >Login</button>
                                    </div>
                                    <div class="form-group d-flex justify-content-between">
                                        <div class="form-check form-check-flat mt-0">
                                            <label class="form-check-label">
                                                <input type="checkbox" class="form-check-input" checked> Manter Acessado
                                            </label>
                                        </div>
                                        <a href="#" class="text-small forgot-password text-black">Esqueci Minha Senha</a>
                                    </div>
                                    <div class="text-block text-center my-3">
                                        <span class="text-small font-weight-semibold">Ainda não está cadastrado?</span>
                                        <a href="register.jsp" class="text-black text-small">Crie uma conta</a>
                                    </div>
                                </form>
                            </div>
                            <ul class="auth-footer">
                                <li>
                                    <a href="#">Termos e Condições</a>
                                </li>
                                <li>
                                    <a href="#">Ajuda</a>
                                </li>
                            </ul>
                            <p class="footer-text text-center">copyright © 2018 Tavinho's Library. Todos os direitos reservados.</p>
                        </div>
                    </div>
                </div>
                <!-- content-wrapper ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="vendors/js/vendor.bundle.base.js"></script>
        <script src="vendors/js/vendor.bundle.addons.js"></script>
        <!-- endinject -->
        <!-- inject:js -->
        <script src="js/off-canvas.js"></script>
        <script src="js/misc.js"></script>
        <!-- endinject -->
    </body>

</html>
