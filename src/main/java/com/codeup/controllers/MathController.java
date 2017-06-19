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
    public Integer add(@PathVariable int firstNum, @PathVariable int secondNum){
        return firstNum + secondNum;
    }

    @GetMapping("/subtract/{firstNum}/from/{secondNum}")
    @ResponseBody
    public Integer subtract(@PathVariable int firstNum, @PathVariable int secondNum){
        return secondNum - firstNum;
    }

    @GetMapping("/multiply/{firstNum}/and/{secondNum}")
    @ResponseBody
    public long Multiplication(@PathVariable long firstNum, @PathVariable long secondNum){
        return firstNum * secondNum;
    }

    @GetMapping("/divide/{firstNum}/by/{secondNum}")
    @ResponseBody
    public long divide(@PathVariable long firstNum, @PathVariable long secondNum){
        return firstNum / secondNum;
    }
}
