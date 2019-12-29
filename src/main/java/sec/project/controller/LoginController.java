/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;

/**
 *
 * @author ville
 **/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    //TODO:is it necessary to explicitly define this is is this done automagically?
    //not it does not happen automagically, needs to be here...
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}

