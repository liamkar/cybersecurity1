package sec.project.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Event;
import sec.project.domain.Signup;
import sec.project.repository.AccountRepository;
import sec.project.repository.EventRepository;


@Controller
public class SignupController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EventRepository eventRepository;
    
    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/events";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(Principal principal, @RequestParam Long eventId, @RequestParam String name, @RequestParam String address) {
        Event event = eventRepository.getOne(eventId);
        
        
        List<Signup> signups = event.getSignups();
        if (signups == null || signups.size() == 0) {
            signups = new ArrayList();
        }
        
        Signup signup = new Signup(name, address);
        signup.setAccount(accountRepository.findByUsername(principal.getName()));
        signup.setEvent(event);

        signups.add(signup);
        event.setSignups(signups);
        eventRepository.save(event);
        
        return "done";
    }

}
