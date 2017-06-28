package com.codeup.controllers;

import com.codeup.Repositories.UsersRepositories;
import com.codeup.Services.PostSvc;
import com.codeup.models.Post;
import com.codeup.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class PostsController {

    private final PostSvc postSvc;
    private UsersRepositories usersDao;

    @Value("${file-upload-path}")
    private String uploadPath;

    @Autowired
    public PostsController(PostSvc postSvc, UsersRepositories usersDao) {
        this.postSvc = postSvc;//connect services
        this.usersDao = usersDao;
    }

    @GetMapping("/post.json")
    public @ResponseBody
    Iterable<Post> viewAll(){
        return postSvc.findAll();
    }

    @GetMapping("/posts/ajax")
    public String viewAllPostUsingAnAjaxCall() {
        return "posts/ajax";
    }

    @GetMapping("/posts")
    public String viewAll(Model model) {
        Iterable<Post> posts = postSvc.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        // Inside the method that shows an individual posts, create a new posts object and pass it to the view.
        Post post = postSvc.findOne(id);
        model.addAttribute("posts", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(
        @Valid Post post,
        Errors validation,
        @RequestParam(name = "file") MultipartFile uploadedFile,
        Model model
    ){
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }

        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);

        try {
            uploadedFile.transferTo(destinationFile);
            model.addAttribute("message", "File successfully uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setImageUrl(filename);
        post.setOwner(user);
        postSvc.save(post);
        model.addAttribute("post", post);
        return "redirect:/posts";

    }


    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @PostMapping("/post/delete")
    public String deletePost(@ModelAttribute Post post, Model model){
        postSvc.deletePost(post.getId());
        model.addAttribute("msg", "Your post was deleted correctly");
        return "return the view with a success message";
    }
}