<%-- 
    Document   : cdLivro
    Created on : 16/04/2019, 23:36:55
    Author     : João Otavio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, 
        DAOs.DAOGenero,
        DAOs.DAOLocal,
        DAOs.DAOEditora,
        DAOs.DAOAutor,
        Entidades.Genero, 
        Entidades.Local, 
        Entidades.Editora, 
        Entidades.Autor, 
        java.text.NumberFormat" %>
<%
    Locale ptBr = new Locale("pt", "BR");
    DAOGenero daoGenero = new DAOGenero();
    DAOEditora daoEditora = new DAOEditora();
    DAOAutor daoAutor = new DAOAutor();
    DAOLocal daoLocal = new DAOLocal();
        
    List<Genero> generos = daoGenero.listInOrderId();
    List<Editora> editoras = daoEditora.listInOrderId();
    List<Autor> autores = daoAutor.listInOrderId();
    List<Local> locais = daoLocal.listInOrderId();
    
%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Tavinho's System</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="../../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="../../vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="../../vendors/css/vendor.bundle.addons.css">
        <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
        <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
        <!-- endinject -->
        <!-- plugin css for this page -->
        <link rel="stylesheet" href="vendors/iconfonts/font-awesome/css/font-awesome.css">
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <link rel="stylesheet" href="css/style.css">
        <!-- endinject -->
        <link rel="shortcut icon" href="img/favicon.png" />
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
            <!-- partial:partials/_navbar.html -->
            <nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
                <div class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
                    <a class="navbar-brand brand-logo" href="index.jsp">
                        <img src="img/logo.svg" alt="logo" />
                    </a>
                    <a class="navbar-brand brand-logo-mini" href="system.jsp">
                        <img src="img/logo-mini.svg" alt="logo" />
                    </a>
                </div>
                <div class="navbar-menu-wrapper d-flex align-items-center">
                    <ul class="navbar-nav navbar-nav-left header-links d-none d-md-flex">
                        <li class="nav-item">
                            <a href="#" class="nav-link">Pendentes
                                <span class="badge badge-primary ml-1">New</span>
                            </a>
                        </li>
                        <li class="nav-item active">
                            <a href="#" class="nav-link">
                                <i class="mdi mdi-elevation-rise"></i>Reservados</a>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link">
                                <i class="mdi mdi-bookmark-plus-outline"></i>Permanência</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav navbar-nav-right">
                        <li class="nav-item dropdown">
                            <a class="nav-link count-indicator dropdown-toggle" id="messageDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
                                <i class="mdi mdi-file-document-box"></i>
                                <span class="count">7</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="messageDropdown">
                                <div class="dropdown-item">
                                    <p class="mb-0 font-weight-normal float-left">You have 7 unread mails
                                    </p>
                                    <span class="badge badge-info badge-pill float-right">View all</span>
                                </div>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item preview-item">
                                    <div class="preview-thumbnail">
                                        <img src="img/faces/face4.jpg" alt="image" class="profile-pic">
                                    </div>
                                    <div class="preview-item-content flex-grow">
                                        <h6 class="preview-subject ellipsis font-weight-medium text-dark">David Grey
                                            <span class="float-right font-weight-light small-text">1 Minutes ago</span>
                                        </h6>
                                        <p class="font-weight-light small-text">
                                            The meeting is cancelled
                                        </p>
                                    </div>
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item preview-item">
                                    <div class="preview-thumbnail">
                                        <img src="img/faces/face2.jpg" alt="image" class="profile-pic">
                                    </div>
                                    <div class="preview-item-content flex-grow">
                                        <h6 class="preview-subject ellipsis font-weight-medium text-dark">Tim Cook
                                            <span class="float-right font-weight-light small-text">15 Minutes ago</span>
                                        </h6>
                                        <p class="font-weight-light small-text">
                                            New product launch
                                        </p>
                                    </div>
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item preview-item">
                                    <div class="preview-thumbnail">
                                        <img src="img/faces/face3.jpg" alt="image" class="profile-pic">
                                    </div>
                                    <div class="preview-item-content flex-grow">
                                        <h6 class="preview-subject ellipsis font-weight-medium text-dark"> Johnson
                                            <span class="float-right font-weight-light small-text">18 Minutes ago</span>
                                        </h6>
                                        <p class="font-weight-light small-text">
                                            Upcoming board meeting
                                        </p>
                                    </div>
                                </a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
                                <i class="mdi mdi-bell"></i>
                                <span class="count">4</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="notificationDropdown">
                                <a class="dropdown-item">
                                    <p class="mb-0 font-weight-normal float-left">You have 4 new notifications
                                    </p>
                                    <span class="badge badge-pill badge-warning float-right">View all</span>
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item preview-item">
                                    <div class="preview-thumbnail">
                                        <div class="preview-icon bg-success">
                                            <i class="mdi mdi-alert-circle-outline mx-0"></i>
                                        </div>
                                    </div>
                                    <div class="preview-item-content">
                                        <h6 class="preview-subject font-weight-medium text-dark">Application Error</h6>
                                        <p class="font-weight-light small-text">
                                            Just now
                                        </p>
                                    </div>
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item preview-item">
                                    <div class="preview-thumbnail">
                                        <div class="preview-icon bg-warning">
                                            <i class="mdi mdi-comment-text-outline mx-0"></i>
                                        </div>
                                    </div>
                                    <div class="preview-item-content">
                                        <h6 class="preview-subject font-weight-medium text-dark">Settings</h6>
                                        <p class="font-weight-light small-text">
                                            Private message
                                        </p>
                                    </div>
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item preview-item">
                                    <div class="preview-thumbnail">
                                        <div class="preview-icon bg-info">
                                            <i class="mdi mdi-email-outline mx-0"></i>
                                        </div>
                                    </div>
                                    <div class="preview-item-content">
                                        <h6 class="preview-subject font-weight-medium text-dark">New user registration</h6>
                                        <p class="font-weight-light small-text">
                                            2 days ago
                                        </p>
                                    </div>
                                </a>
                            </div>
                        </li>
                        <li class="nav-item dropdown d-none d-xl-inline-block">
                            <a class="nav-link dropdown-toggle" id="UserDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
                                <span class="profile-text">Olá, João Otavio!</span>
                                <img class="img-xs rounded-circle" src="img/faces/joao.jpeg" alt="Profile image">
                            </a>
                            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
                                <a class="dropdown-item p-0">
                                    <div class="d-flex border-bottom">
                                        <div class="py-3 px-4 d-flex align-items-center justify-content-center">
                                            <i class="mdi mdi-bookmark-plus-outline mr-0 text-gray"></i>
                                        </div>
                                        <div class="py-3 px-4 d-flex align-items-center justify-content-center border-left border-right">
                                            <i class="mdi mdi-account-outline mr-0 text-gray"></i>
                                        </div>
                                        <div class="py-3 px-4 d-flex align-items-center justify-content-center">
                                            <i class="mdi mdi-alarm-check mr-0 text-gray"></i>
                                        </div>
                                    </div>
                                </a>
                                <a class="dropdown-item mt-2">
                                    Manage Accounts
                                </a>
                                <a class="dropdown-item">
                                    Change Password
                                </a>
                                <a class="dropdown-item">
                                    Check Inbox
                                </a>
                                <a class="dropdown-item">
                                    Sign Out
                                </a>
                            </div>
                        </li>
                    </ul>
                    <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
                        <span class="mdi mdi-menu"></span>
                    </button>
                </div>
            </nav>
            <!-- partial -->
            <div class="container-fluid page-body-wrapper">
                <!-- partial:partials/_sidebar.html -->
                <nav class="sidebar sidebar-offcanvas" id="sidebar">
                    <ul class="nav">
                        <li class="nav-item nav-profile">
                            <div class="nav-link">
                                <div class="user-wrapper">
                                    <div class="profile-image">
                                        <img src="img/faces/joao.jpeg" alt="profile image">
                                    </div>
                                    <div class="text-wrapper">
                                        <p class="profile-name">João Otavio</p>
                                        <div>
                                            <small class="designation text-muted">Estudante</small>
                                            <span class="status-indicator online"></span>
                                        </div>
                                    </div>
                                </div>
                                <button class="btn btn-success btn-block" onClick="window.location.href = 'reserva.jsp'">Buscar Livro
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="system.jsp">
                                <i class="menu-icon mdi mdi-television"></i>
                                <span class="menu-title">Home</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-content-copy"></i>
                                <span class="menu-title">Empréstimos</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="ui-basic">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item">
                                        <a class="nav-link" href="renova.jsp">Listar/ Renovar</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="reserva.jsp">Reservar</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="estatisticas.jsp">
                                <i class="menu-icon mdi mdi-chart-line"></i>
                                <span class="menu-title">Estatísticas</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="vencimentos.jsp">
                                <i class="menu-icon mdi mdi-alert"></i>
                                <span class="menu-title">Vencimentos</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="conta.jsp">
                                <i class="menu-icon mdi mdi-account-circle"></i>
                                <span class="menu-title">Conta</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="cdLivro.jsp">
                                <i class="menu-icon mdi mdi-plus-outline"></i>
                                <span class="menu-title">Cadastrar Livro</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="cdEditora.jsp">
                                <i class="menu-icon mdi mdi-plus-outline"></i>
                                <span class="menu-title">Cadastrar Editora</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="cdGenero.jsp">
                                <i class="menu-icon mdi mdi-plus-outline"></i>
                                <span class="menu-title">Cadastrar Genero</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="cdLocal.jsp">
                                <i class="menu-icon mdi mdi-plus-outline"></i>
                                <span class="menu-title">Cadastrar Local</span>
                            </a>
                        </li><li class="nav-item">
                            <a class="nav-link" href="cdAutor.jsp">
                                <i class="menu-icon mdi mdi-plus-outline"></i>
                                <span class="menu-title">Cadastrar Autor</span>
                            </a>
                        </li>
                        </li><li class="nav-item">
                            <a class="nav-link" href="cdOperador.jsp">
                                <i class="menu-icon mdi mdi-plus-outline"></i>
                                <span class="menu-title">Cadastrar Operador</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-format-list-bulleted"></i>
                                <span class="menu-title">Listagens</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="ui-basic">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item">
                                        <a class="nav-link" href="listar.jsp">Empréstimos</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="listarlivro.jsp">Livros</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="listarusuarios.jsp">Usuários</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="listaroperadores.jsp">Operadores</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="listargeneros.jsp">Generos</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="listareditoras.jsp">Editoras</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="listarautores.jsp">Autores</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="listarlocais.jsp">Locais</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </nav>
                <!-- partial -->
                <div class="main-panel">
                    <div class="content-wrapper">
                        <div class="row">
                            <div class="col-md-10 d-flex align-items-stretch grid-margin">
                                <div class="row flex-grow">
                                    <div class="col-10">
                                        <div class="card">
                                            <div class="card-body">
                                                <form name="formCd" action="LocalServlet" method="post">
                                                    <div class="row">

                                                        <div class="col-md-12">
                                                            <h4 class="card-title">Novo local</h4>
                                                            <label>Local</label>
                                                            <input style="font-size: 17px;" type="text" class="form-control" id="titulo" name="nome">
                                                            <br>
                                                        </div>

                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <button type="submit"  class="btn btn-inverse-info btn-fw" name="ok" value="1">Salvar Cadastro</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row purchace-popup">
                        </div>
                    </div>
                    <footer class="footer">
                        <div class="container-fluid clearfix">
                            <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © 2019
                                <a href="index.jsp" target="_blank">TAVINHO'S LIBRARY</a>. All rights reserved.</span>
                            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with
                                <i class="mdi mdi-heart text-danger"></i>
                            </span>
                        </div>
                    </footer>
                </div>
            </div>
        </div>
        <script src="../../js/off-canvas.js"></script>
        <script src="../../js/misc.js"></script>
        <script src="../../js/chart.js"></script>
        <script src="vendors/js/vendor.bundle.base.js"></script>
        <script src="vendors/js/vendor.bundle.addons.js"></script>
        <script src="js/off-canvas.js"></script>
        <script src="js/misc.js"></script>
        <script src="js/dashboard.js"></script>
        <script src="vendors/js/vendor.bundle.base.js"></script>
        <script src="vendors/js/vendor.bundle.addons.js"></script>
        <script src="js/off-canvas.js"></script>
        <script src="js/misc.js"></script>
        <script src="js/chart.js"></script>
    </body>

</html>
