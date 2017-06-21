package com.codeup.controllers;

import com.codeup.Services.PostSvc;
import com.codeup.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// TODO: add posts svc

@Controller
public class PostsController {

    private final PostSvc postSvc;

    @Autowired
    public PostsController(PostSvc postSvc) {
        this.postSvc = postSvc;//conncet services
    }

    @GetMapping("/posts")
    public String viewAll(Model model) {

        // or List<Post> posts = postSvc.findAll()
        model.addAttribute("posts", postSvc.findAll());// or posts

        return "post/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        // Inside the method that shows an individual posts, create a new posts object and pass it to the view.
        Post post = postSvc.findOne(id);
        model.addAttribute("posts", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showPostForm() {
        return "view the form for creating a posts";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String savePost() {
        return "create a new posts";
    }
}