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
            <jsp:include page="/WEB-INF/jsp/modalUploadImagem.jsp"/>
        </c:if>

        <c:if test="${sessionScope.usuario == null}">
            <jsp:include page="/WEB-INF/jsp/usuarioNaoLogadoTopbar.jsp"/>
            <div id="login" class="modal">
                <jsp:include page="/WEB-INF/jsp/login.jsp"/>                
            </div>
            <div id="cadastro" class="modal">
                <jsp:include page="/WEB-INF/jsp/cadastro.jsp"/>
            </div>
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
        <h5 class="muted section-title">Recomendações</h5>
        <div class="recomendacoes row">
            <c:forEach items="${recomendacoes}" var="post"> 
                <a href="/posts/${post.id}">
                    <div class="col l3 m6 s12">
                        <div class="post z-depth-1">
                            <h5>${post.title}</h5>
                            <p class="muted">${post.resumo}</p>
                            <div class="post_footer">
                                <p class="muted">por ${post.authorLogin}</p>
                                <p class="muted"><b>Palavras-chave: </b>${post.keywords}</p>
                                <div class="post-avaliacao">
                                    <p class="avaliacao-positiva"><i class="mdi-action-thumb-up"></i>${post.avaliacoesPositivas.size()}</p>
                                    <p class="avaliacao-negativa"><i class="mdi-action-thumb-down"></i>${post.avaliacoesNegativas.size()}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
        <footer class="blue-grey darken-4 row z-depth-3">
            <div class="post-avaliacao col l2 m3">
                <input type="hidden" value="${post.id}"  id="idPost"/> 
                <c:if test="${!avaliouPost}">
                    <p class="avaliacao-positiva positivo" onclick="avaliar('CURTIR')"><i class="mdi-action-thumb-up"></i>${post.avaliacoesPositivas.size()}</p>
                    <p class="avaliacao-negativa negativo" onclick="avaliar('NAO_CURTIR')"><i class="mdi-action-thumb-down"></i>${post.avaliacoesNegativas.size()}</p>
                    </c:if>
                    <c:if test="${avaliouPost}">
                    <p class="avaliacao-positiva" onclick="Materialize.toast('Você já avaliou o post')"><i class="mdi-action-thumb-up"></i>${post.avaliacoesPositivas.size()}</p>
                    <p class="avaliacao-negativa" onclick="Materialize.toast('Você já avaliou o post')"><i class="mdi-action-thumb-down"></i>${post.avaliacoesNegativas.size()}</p>
                    </c:if>
            </div>
            <!--<form>
                <div class="input-field col l9 m8 row">
                    <input id="first_name" type="text" class="validate col l11 m8">
                    <label for="first_name">Escreva um comentário</label>
                </div>
                <button class="btn waves-effect waves-light col l1 m2" type="submit" name="action">
                    <i class="mdi-content-send right"></i>
                </button>
            </form>-->
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
                        elemento = $('.positivo').append('+1');
                    else if (avaliacao === 'NAO_CURTIR')
                        elemento = $('.negativo').append('+1');
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
