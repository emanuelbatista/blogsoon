<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

    <head>
        <title>BlogSoon</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" media="all"
              href="/css/materialize.min.css"  />
        <link rel="stylesheet" type="text/css" media="all"
              href="/css/index.css"  />
        <link rel="stylesheet" type="text/css" media="all"
              href="/css/blogsoon.css"  />
        <link href='http://fonts.googleapis.com/css?family=Roboto:100,300,700' rel='stylesheet' type='text/css' />    
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="/js/materialize.min.js" ></script>
    </head>

    <body class="grey lighten-4">
        <c:if test="${sessionScope.usuario != null}">
            <jsp:include page="/WEB-INF/jsp/usuarioLogadoTopbar.jsp"/>
            <jsp:include page="/WEB-INF/jsp/modalUploadImagem.jsp"/>
        </c:if>
        <c:if test="${sessionScope.usuario == null}">
            <jsp:include page="/WEB-INF/jsp/usuarioNaoLogadoTopbar.jsp"/>
        </c:if>
        <div id="cadastro" class="modal">
            <jsp:include page="/WEB-INF/jsp/cadastro.jsp"/>
        </div>
        <div id="login" class="modal">
            <jsp:include page="/WEB-INF/jsp/login.jsp"/>
        </div>

        <div class="posts row">
            <h5 class="muted section-title">Em alta</h5>
            <jsp:include page="/WEB-INF/jsp/listagemPosts.jsp" />
        </div>

        <c:if test="${sessionScope.usuario != null}">
            <div class="modal" id="newPostModal">
                <jsp:include page="/WEB-INF/jsp/newPostModal.jsp"/>
            </div>
            <div class="fixed-action-btn modal-trigger" href="#newPostModal" style="bottom: 45px; right: 24px;">
                <a class="btn-floating btn-large waves-effect waves-light grey darken-4"><i class="material-icons mdi-content-add"></i></a>
            </div>
        </c:if>

        <script>
            $(".button-collapse").sideNav();
            $(document).ready(function () {
                $('.modal-trigger').leanModal();
            });


        </script>

    </body>
</html>
