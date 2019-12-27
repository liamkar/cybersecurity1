/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
    

/**
 *
 * @author ville
 */
@Controller
public class EventController {
    
    private List<String> list;

    public EventController() {
        this.list = new ArrayList<>();
        this.list.add("Hello world!");
    }

    /*
    @RequestMapping("/")
    public String home(Model model, @RequestParam(required = false) String content) {
        if (content != null && !content.trim().isEmpty()) {
            this.list.add(0, content.trim());
        }

        int toIndex = Math.min(list.size(), 10);
        
        //model.addAttribute("list", list);
        model.addAttribute("list", list.subList(0, toIndex));
        
        return "index";
    }
    */
}

