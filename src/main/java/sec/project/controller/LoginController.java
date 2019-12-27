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




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Account;
import sec.project.repository.AccountRepository;

@Controller
public class LoginController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder encoder;

    /*
    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/form";
    }
    */

    
    //TODO:is it necessary to explicitly define this is is this done automagically?
    //not it does not happen automagically, needs to be here...
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
   

    /*
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public String changePassword(Authentication authentication, @RequestParam String password) {
        Account account = accountRepository.findByUsername(authentication.getName());
        if (account == null) {
            return "redirect:/index";
        }

        account.setPassword(encoder.encode(password));
        accountRepository.save(account);

        return "thanks";
    }
    */
}

