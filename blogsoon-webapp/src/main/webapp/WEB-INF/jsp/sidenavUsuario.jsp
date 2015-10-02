<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul id="slide-out" class="side-nav">
    <li>
        <a id="slide-out-user-image" href="#uploadImagem" class="modal-trigger">
            <c:if test="${sessionScope.usuario.foto != null}">
                <img src="/usuario/imagem/perfil" alt="${sessionScope.usuario.nome}" title="{sessionScope.usuario.nome}" /> 
            </c:if>
            <c:if test="${sessionScope.usuario.foto == null}">
                <img src="/imagens/perfilDefault.jpg" alt="${sessionScope.usuario.nome}" title="${sessionScope.usuario.nome}" /> 
            </c:if>                                                    
        </a>
    </li>
    <a href="/usuario/logout">
        <li class="menu-item">Sair</li>
    </a>
</ul>