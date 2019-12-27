package sec.project.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Event;
import sec.project.domain.EventSignup;
import sec.project.domain.Signup;
import sec.project.repository.EventRepository;
import sec.project.repository.SignupRepository;

@Controller
public class SignupController {

    //@Autowired
    //private SignupRepository signupRepository;

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
    public String submitForm(@RequestParam Long eventId, @RequestParam String name, @RequestParam String address) {
        //signupRepository.save(new Signup(name, address));
        Event event = eventRepository.getOne(eventId);
        
        /*
        List<EventSignup> eventSignups = event.getEventSignups();
        if (eventSignups == null || eventSignups.size() == 0) {
            eventSignups = new ArrayList();
        }
        */
        
        List<Signup> signups = event.getSignups();
        if (signups == null || signups.size() == 0) {
            signups = new ArrayList();
        }
        
        //EventSignup newEventSignup = new EventSignup();
        Signup signup = new Signup(name, address);
        //signupRepository.
        
        /*
        EventSignup newEventSignup = new EventSignup();
        newEventSignup.setSignup(signup);
        
        eventSignups.add(newEventSignup);
        event.setEventSignups(eventSignups);
        eventRepository.save(event);
        */
        signups.add(signup);
        event.setSignups(signups);
        eventRepository.save(event);
        
        return "done";
    }

}
