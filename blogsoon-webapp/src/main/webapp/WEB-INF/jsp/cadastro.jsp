<%-- 
    Document   : cadastro.jsp
    Created on : 26/07/2015, 21:30:25
    Author     : Emanuel Batista da Silva Filho - emanuelbatista2011@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div id="formsContent">
    <form:form method="post" id="form" action="cadastro" modelAttribute="usuario" cssClass="row">
        <div class="modal-content">
            <!--<form action="" class="row">-->
            <form:errors path="*"/>
            <div class="input-field col s12">
                <form:input id="cadastro_nome" path="nome"/>
                <!--<input id="cadastro_nome" type="text" class="validate" required="true"/>-->
                <label for="cadastro_nome" name="nome">Nome</label>
            </div>
            <div class="input-field col s12">
                <!--<input id="cadastro_sobrenome" type="text" class="validate" />-->
                <form:input path="sobrenome" id="cadastro_sobrenome" cssClass="validate"/>
                <label for="cadastro_sobrenome" name="sobrenome" required="true">Sobrenome</label>
            </div>
            <div class="input-field col s12">
                <!--<input id="cadastro_login" type="text" class="validate" />-->
                <form:input path="login" id="cadastro_login" cssClass="validate"/>
                <label for="cadastro_login" name="login" required="true">Login</label>
            </div>
            <div class="input-field col s12">
                <!--<input id="cadastro_senha" type="text" class="validate" />-->
                <form:input path="senha" id="cadastro_senha" class="validate"/>
                <label for="cadastro_senha" name="senha" required="true">Senha</label>
            </div>
            <!--</form>-->
        </div>
        <div class="modal-footer">
            <!--<a href="#" class="waves-effect waves-green btn-flat modal-action modal-close">Cadastrar</a>-->
            <input type="submit" value="Cadastrar" class="waves-effect waves-green btn-flat modal-action modal-close"> 
        </div>
    </form:form>
    <script>
        $(document).ready(function () {
            $("#form").submit(function () {
                $.post($(this).attr("action"), $(this).serialize(), function (html) {
                    $("#formsContent").replaceWith(html);
                });
                return false;
            });
        });
    </script>

</div>
