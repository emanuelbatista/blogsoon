<%-- 
    Document   : listagemPosts
    Created on : 01/10/2015, 17:08:34
    Author     : douglasgabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${posts}" var="post">
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
