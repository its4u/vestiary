package com.bil.vestiary.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @ResponseBody
    @GetMapping(value = "/")
    public String home() {
        String html = "Welcome";
        html += "<ul>";
        html += "</ul>";
        return html;
    }

}
