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
        <link rel="stylesheet" type="text/css" media="all"
              href="/css/blogsoon.css"  />
        <link href='http://fonts.googleapis.com/css?family=Roboto:100,300,700' rel='stylesheet' type='text/css' />    
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="/js/materialize.min.js" ></script>
    </head>

    <body>
        <div class="modal" id="newPostModal">
            <jsp:include page="/WEB-INF/jsp/newPostModal.jsp"/>
        </div>

        <jsp:include page="/WEB-INF/jsp/usuarioLogadoTopbar.jsp"/>
        

        
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

