<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar-fixed">
    <nav class="blue-grey darken-4">
        <div class="nav-wrapper blue-grey darken-4">
            <a href="#!" class="brand-logo">
                <img src="../../imagens/logo.png">
            </a>
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
            <jsp:include page="/WEB-INF/jsp/sidenavUsuario.jsp"/>
            <a href="#" data-activates="slide-out" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
        </div>
    </nav>

</div>