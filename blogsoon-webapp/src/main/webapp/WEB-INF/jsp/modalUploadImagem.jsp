<div id="uploadImagem" class="modal">
    <div class="modal-content">
        <h4>Mudar foto do perfil</h4>
        <form action="/usuario/salvar/imagem" method="post" enctype="multipart/form-data">
            <div class="file-field input-field">
                <input class="file-path validate" type="text"/>
                <div class="btn">
                    <span>Arquivo</span>
                    <input type="file" name="file"/>
                </div>
            </div>
            <input type="submit" />
        </form>
    </div>
    <div class="modal-footer">                
    </div>
</div>