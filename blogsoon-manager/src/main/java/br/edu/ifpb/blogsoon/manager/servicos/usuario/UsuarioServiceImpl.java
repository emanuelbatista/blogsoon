package br.edu.ifpb.blogsoon.manager.servicos.usuario;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.exceptions.LoginException;
import br.edu.ifpb.blogsoon.manager.repositorios.usuario.UsuarioRepository;
import javax.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Service
public class UsuarioServiceImpl{

    @Autowired
    private UsuarioRepository repositorio;

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
    
    public void atualizar (Usuario usuario){
        repositorio.save(usuario);
    }

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

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Usuario recuperar(String login) {
        return repositorio.findOne(login);
    }

}
