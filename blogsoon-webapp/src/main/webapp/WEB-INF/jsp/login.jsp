<%-- 
    Document   : login
    Created on : 27/07/2015, 18:58:46
    Author     : douglasgabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div id="formContent">
    <div class="modal-content">
        <form class="col s12" action="/usuario/login" method="post">
            <div class="row">
                <div class="input-field col s12">
                    <input id="login_login" type="text" class="validate" name="login">
                    <label for="login_login">Login</label>
                </div>
                <div class="input-field col s12">
                    <input id="login_password" type="password" class="validate" name="senha">
                    <label for="login_password">Senha</label>
                </div>
                <div class="input-field col s6">
                    <input type="submit" class="validate">                    
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#form").submit(function () {
            $.post($(this).attr("action"), $(this).serialize(), function (html) {
                $("#formContent").replaceWith(html);
            });
            return false;
        });
    });    
    Materialize.toast('${loginErro}', 4000);
</script>
