package br.edu.ifpb.blogsoon.webapp.controller.post;

import br.edu.ifpb.blogsoon.core.entidades.Post;
import br.edu.ifpb.blogsoon.manager.repositorios.post.PostRepository;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author marciel
 */
@Controller
public class PostController {

    @Autowired
    private PostRepository repository;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public @ResponseBody
    String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String handleFileUpload(
            @RequestParam("title") String title,
            @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                PegDownProcessor processor = new PegDownProcessor();
                
                String content = "";
                
                byte[] bytes = file.getBytes();
                BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
                List<String> list = reader.lines().collect(Collectors.toList());
                
                for (String a : list) {
                    content = content.concat(processor.markdownToHtml(a));
                }
                
                repository.save(new Post(title, content));
                
                return content;
            } catch (Exception e) {
                return "You failed to upload " + title + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + title + " because the file was empty.";
        }
    }
}
