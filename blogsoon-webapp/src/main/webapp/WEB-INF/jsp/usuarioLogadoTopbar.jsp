<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar-fixed">
    <nav class="blue-grey darken-4">
        <div class="nav-wrapper blue-grey darken-4">
            <a href="#!" class="brand-logo">BlogSoon</a>
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
            <ul id="slide-out" class="side-nav">
                <li>
                    <a href="#uploadImagem" class="modal-trigger">
                        <c:if test="${sessionScope.usuario.foto != null}">
                            <img src="/usuario/imagem/perfil" alt="${sessionScope.usuario.nome}" title="{sessionScope.usuario.nome}" /> 
                        </c:if>
                        <c:if test="${sessionScope.usuario.foto == null}">
                            <img src="/imagens/perfilDefault.jpg" alt="${sessionScope.usuario.nome}" title="${sessionScope.usuario.nome}" /> 
                        </c:if>                                                    
                    </a>
                </li>
            </ul>
            <a href="#" data-activates="slide-out" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
        </div>
    </nav>

</div>