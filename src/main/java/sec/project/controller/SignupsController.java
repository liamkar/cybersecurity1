/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sec.project.domain.Signup;
import sec.project.repository.AccountRepository;
import sec.project.repository.SignupRepository;

/**
 *
 * 
 * @author ville
 */
@Controller
public class SignupsController {
    
    @Autowired
    private AccountRepository accountRepository;
     
    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping(value = "/signups/{name}", method = RequestMethod.GET)
    public String signups(Model model, @PathVariable String name) {

        System.out.println("name parameter:"+name);
        List<Signup> signups = signupRepository.getSignupsByAccountUsername(name);
        
        model.addAttribute("signups", signups);

        return "signups";
    }
}
