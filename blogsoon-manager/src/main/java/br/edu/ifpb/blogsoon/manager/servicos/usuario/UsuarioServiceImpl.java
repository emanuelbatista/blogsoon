package br.edu.ifpb.blogsoon.manager.servicos.usuario;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.exceptions.LoginException;
import br.edu.ifpb.blogsoon.manager.repositorios.usuario.UsuarioRepository;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Named;
import javax.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public void salvar(Usuario usuario) throws PersistenceException {
        if (repositorio.findOne(usuario.getLogin()) != null) {
            throw new PersistenceException("O login informado já foi cadastrado");
        } else {
            repositorio.save(usuario);
//            File file = new File("imagens/" + usuario.getLogin());
//            if (!file.exists()) {
//                file.mkdir();
//            }
        }
    }

    @Override
    public Usuario login(String login, String senha) throws LoginException {
        Usuario usuario;
        if ((usuario = repositorio.findOne(login)) != null) {
            if (usuario.getSenha().equals(senha)) {
                return usuario;
            } else {
                throw new LoginException("Senha inválida");
            }
        } else {
            throw new LoginException("Login inválido");
        }
    }

//    @Override
//    public void salvarImagemPerfil(Usuario usuario, byte[] imagem) throws FileNotFoundException, IOException {
//        System.out.println("Método do serviço que salva imagem");
////        String caminhoArquivo = "imagens/" + usuario.getLogin() + "/perfil.jpg";
////        File arquivoParaSalvar = new File(caminhoArquivo);
////        if (!arquivoParaSalvar.exists())
////            arquivoParaSalvar.createNewFile();
////        FileOutputStream fos = new FileOutputStream(arquivoParaSalvar);
////        fos.write(imagem);
//        System.out.println("Arquivo escrito");
//        usuario.setFoto();
//        repositorio.save(usuario);
//        System.out.println("Arquivo atribuido ao usuario");
//    }

}
