<%-- 
    Document   : newPostModal
    Created on : 01/10/2015, 15:50:50
    Author     : douglasgabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="modal-content">
    <h4>Submeter nova postagem:</h4>
    <form class="col s12" action="/posts/upload" method="post" enctype="multipart/form-data">
        <div class="row">            
            <div class="file-field input-field row">
                <div class="btn col s2">
                    <span><i class="mdi-av-playlist-add"></i>Arquivo</span>
                    <input name="file" type="file" accept=".md" />
                </div>
                <input name="file" class="file-path validate col s10" type="text" accept=".md"/>                                
            </div>
            <div class="input-field col s12">
                <input id="login_login" type="text" class="validate" name="title">
                <label for="login_login">Título</label>
            </div>
            <div class="input-field col s6">
                <input type="submit" class="validate btn">                    
            </div>
        </div>
    </form>
</div>

