<%-- 
    Document   : home
    Created on : 29/07/2015, 11:23:26
    Author     : douglasgabriel
--%>

<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <title>BlogSoon - Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" media="all"
              href="/css/materialize.min.css"  />
        <link rel="stylesheet" type="text/css" media="all"
              href="/css/home.css"  />
        <link href='http://fonts.googleapis.com/css?family=Roboto:100,300,700' rel='stylesheet' type='text/css' />    
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="/js/materialize.min.js" ></script>
    </head>

    <body>
        <div class="navbar-fixed">
            <nav class="blue-grey darken-4">
                <a href="#!" class="brand-logo">BlogSoon</a>
                <ul class="right top-bar">
                    <li>
                        <a href="#!" onclick="$('.button-collapse').sideNav('show');">
                            <c:if test="${sessionScope.usuario.foto != null}">
                                <img src="/usuario/imagem/perfil" alt="${sessionScope.usuario.nome}" title="{sessionScope.usuario.nome}" /> 
                            </c:if>
                            <c:if test="${sessionScope.usuario.foto == null}">
                                <img src="/imagens/perfilDefault.jpg" alt="${sessionScope.usuario.nome}" title="${sessionScope.usuario.nome}" /> 
                            </c:if>
                            <h5>${sessionScope.usuario.nome}</h5>
                        </a>
                    </li>
                </ul>
                <ul id="slide-out" class="side-nav">
                    <li>
                        <a href="#uploadImagem" class="modal-trigger">
                            <c:if test="${sessionScope.usuario.foto != null}">
                                <img src="/usuario/imagem/perfil" alt="${sessionScope.usuario.nome}" title="{sessionScope.usuario.nome}" /> 
                            </c:if>
                            <c:if test="${sessionScope.usuario.foto == null}">
                                <img src="/imagens/perfilDefault.jpg" alt="${sessionScope.usuario.nome}" title="${sessionScope.usuario.nome}" /> 
                            </c:if>                                                    
                        </a>
                    </li>
                </ul>
                <a href="#" data-activates="slide-out" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
            </nav>
        </div>
        <div id="uploadImagem" class="modal">
            <div class="modal-content">
                <h4>Mudar foto do perfil</h4>
                <form action="/usuario/salvar/imagem" method="post" enctype="multipart/form-data">
                    <div class="file-field input-field">
                        <input class="file-path validate" type="text"/>
                        <div class="btn">
                            <span>Arquivo</span>
                            <input type="file" name="file"/>
                        </div>
                    </div>
                    <input type="submit" />
                </form>
            </div>
            <div class="modal-footer">                
            </div>
        </div>
        <script>
            $(".button-collapse").sideNav({
                edge: 'rigth'
            });
            $(document).ready(function () {
                $('.modal-trigger').leanModal();
            });
        </script>

    </body>
</html>

