package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by renecortez on 6/20/17.
 */

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/resume")
    public String ShowResume(){
        return "resume";
    }

    @GetMapping("/portfolio")
    public String showPortfolio(){
        return "portfolio";
    }

    @GetMapping("/hello")
    public String hello(){
        // With a ResponseBody annotation it will return the value produced by this method as response
        return "hello";//it'll look for the view within templates if no ResponseBody annotation is found
    }




















//    @GetMapping("/hello/{name}/{lastName}") // shortcut for RequestMapping (method = GET)
//    @ResponseBody
//    public String helloFriend(@PathVariable String name, @PathVariable String lastName) {
//        return String.format("Hello %s %s!", name, lastName);
//    }
//
//    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
//    @ResponseBody
//    public String addOne(@PathVariable int number) {
//        // if, switch, while, do-while, for
//        return number + " plus one is " + (number + 1) + "!";
//    }
}
