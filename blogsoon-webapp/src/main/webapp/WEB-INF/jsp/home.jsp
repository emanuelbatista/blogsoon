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
        <div class="modal" id="newPostModal">
            <jsp:include page="/WEB-INF/jsp/newPostModal.jsp"/>
        </div>

        <jsp:include page="/WEB-INF/jsp/usuarioLogadoTopbar.jsp"/>

        <div class="fixed-action-btn modal-trigger" href="#newPostModal" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light grey darken-4"><i class="material-icons mdi-content-add"></i></a>
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

