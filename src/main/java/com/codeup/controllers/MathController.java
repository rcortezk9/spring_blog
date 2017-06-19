package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by renecortez on 6/19/17.
 */
@Controller
public class MathController {


    @GetMapping("/add/{firstNum}/and/{secondNum}")
    @ResponseBody
    public int add(@PathVariable int firstNum, @PathVariable int secondNum){
        return firstNum + secondNum;
    }

    @GetMapping("/subtract/{firstNum}/from/{secondNum}")
    @ResponseBody
    public int subtract(@PathVariable int firstNum, @PathVariable int secondNum){
        return firstNum - secondNum;
    }

    @GetMapping("/multiply/{firstNum}/and/{secondNum}")
    @ResponseBody
    public int Multiplication(@PathVariable int firstNum, @PathVariable int secondNum){
        return firstNum * secondNum;
    }

    @GetMapping("/divide/{firstNum}/by/{secondNum}")
    @ResponseBody
    public double divide(@PathVariable int firstNum, @PathVariable int secondNum){
        return (double) firstNum / secondNum;
    }
}
