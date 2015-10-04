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
        <footer class="blue-grey darken-4 row">
            <div class="post-avaliacao col l2 m3">
                <input type="hidden" value="${post.id}"  id="idPost"/> 
                <c:if test="${!avaliouPost}">
                    <p class="avaliacao-positiva" onclick="avaliar('CURTIR')"><i class="mdi-action-thumb-up"></i>${post.avaliacoesPositivas.size()}</p>
                    <p class="avaliacao-negativa" onclick="avaliar('NAO_CURTIR')"><i class="mdi-action-thumb-down"></i>${post.avaliacoesNegativas.size()}</p>
                </c:if>
                <c:if test="${avaliouPost}">
                    <p class="avaliacao-positiva" onclick="Materialize.toast('Você já avaliou o post')"><i class="mdi-action-thumb-up"></i>${post.avaliacoesPositivas.size()}</p>
                    <p class="avaliacao-negativa" onclick="Materialize.toast('Você já avaliou o post')"><i class="mdi-action-thumb-down"></i>${post.avaliacoesNegativas.size()}</p>
                </c:if>
            </div>
            <form>
                <div class="input-field col l9 m8 row">
                    <input id="first_name" type="text" class="validate col l11 m8">
                    <label for="first_name">Escreva um comentário</label>
                </div>
                <button class="btn waves-effect waves-light col l1 m2" type="submit" name="action">
                    <i class="mdi-content-send right"></i>
                </button>
            </form>
        </footer>
    </body>
    <script>
        $(".button-collapse").sideNav({
            edge: 'rigth'
        });
        $(document).ready(function () {
            $('.modal-trigger').leanModal();
        });
        function avaliar(avaliacao) {
            var formData = new FormData();
            formData.append('idPost', $('#idPost').attr('value'));
            formData.append('tipo', avaliacao);
            var xhr = new XMLHttpRequest();
            xhr.open('POST', '/avaliacao/add', true);
            xhr.onload = function () {
                if (xhr.status === 200) {
                    var elemento;
                    if (avaliacao === 'CURTIR')
                        elemento = $('.avaliacao-positiva').append('+1');
                    else if (avaliacao === 'NAO_CURTIR')
                        elemento = $('.avaliacao-negativa').append('+1');
                    Materialize.toast('Obrigado por avaliar este post', 14000);
                } else if (xhr.status === 403)
                    Materialize.toast('Você já valiou este post', 14000);
                else
                    Materialize.toast('É preciso estar logado para votar', 14000);
            };
            xhr.send(formData);
        }
    </script>
</html>
