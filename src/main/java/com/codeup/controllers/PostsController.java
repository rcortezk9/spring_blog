package com.codeup.controllers;

import com.codeup.Services.PostSvc;
import com.codeup.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// TODO: add posts svc

@Controller
public class PostsController {

    private final PostSvc postSvc;

    @Autowired
    public PostsController(PostSvc postSvc) {
        this.postSvc = postSvc;//connect services
    }

    @GetMapping("/posts")
    public String viewAll(Model model) {

        // or List<Post> posts = postSvc.findAll()
        model.addAttribute("posts", postSvc.findAll());// or posts

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
        model.addAttribute("posts", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(
        @RequestParam(name = "title") String title,
        @RequestParam(name = "body") String body,
        Model model
    ){
        Post post = new Post(title, body);
        postSvc.save(post);
        model.addAttribute("posts", post);
        return "posts/create";
    }
}