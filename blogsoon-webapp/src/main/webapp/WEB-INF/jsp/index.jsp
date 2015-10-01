<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



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

    <body class="grey lighten-5">
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper blue-grey darken-4">
                    <div class="col s12">
                        <a href="#!" class="brand-logo">BlogSoon</a>
                        <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="mdi-action-view-quilt"></i></a>
                        <ul class="right hide-on-med-and-down">
                            <li><a href="#login" class="modal-trigger">Login</a></li>
                            <li><a href="#cadastro" class="modal-trigger">Cadastro</a></li>
                        </ul>
                        <ul class="side-nav" id="mobile-demo">
                            <li><a href="#login" class="modal-trigger">Login</a></li>
                            <li><a href="#cadastro" class="modal-trigger">Cadastro</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
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
        
        <script>
            $(".button-collapse").sideNav();
            $(document).ready(function () {
                $('.modal-trigger').leanModal();
            });


        </script>

    </body>
</html>
