<%-- 
    Document   : article
    Created on : 01/10/2015, 22:02:45
    Author     : douglasgabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${post.title}</title>
        <link rel="stylesheet" type="text/css" media="all"
              href="/css/materialize.min.css"  />
        <link rel="stylesheet" type="text/css" media="all"
              href="/css/article.css"  />
        <link rel="stylesheet" type="text/css" media="all"
              href="/css/blogsoon.css"  />
        <link href='http://fonts.googleapis.com/css?family=Roboto:100,300,700' rel='stylesheet' type='text/css' />    
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="/js/materialize.min.js" ></script>
    </head>
    <body class="blue-grey lighten-4">
        <c:if test="${sessionScope.usuario != null}">
            <jsp:include page="/WEB-INF/jsp/usuarioLogadoTopbar.jsp"/>
        </c:if>
        <c:if test="${sessionScope.usuario == null}">
            <jsp:include page="/WEB-INF/jsp/usuarioNaoLogadoTopbar.jsp"/>
        </c:if>
        <header class="blue-grey darken-4">
            <div class="content">
                <h3>${post.title}</h3>
                <p class="muted">${requestScope.usuario.nome}</p>
                <p class="muted">${post.keywords}</p>
            </div>
        </header>
        <div class="post content z-depth-1">
            ${post.content}
        </div>
    </body>
    <script>
        $(".button-collapse").sideNav({
            edge: 'rigth'
        });
        $(document).ready(function () {
            $('.modal-trigger').leanModal();
        });
    </script>
</html>
