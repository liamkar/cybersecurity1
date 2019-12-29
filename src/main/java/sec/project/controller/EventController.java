/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sec.project.domain.Event;
import sec.project.repository.AccountRepository;
import sec.project.repository.EventRepository;
    

/**
 *
 * @author ville
 */
@Controller
public class EventController {
       
    @Autowired
    private EventRepository eventRepository;
    

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String list(Principal principal, Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "events";
    }
    
    @RequestMapping(value = "/events/{eventId}", method = RequestMethod.GET)
    public String eventSignups(Principal principal, @PathVariable Long eventId, Model model) {
                        
        Event event = eventRepository.getOne(eventId);
                
        model.addAttribute("signups", event.getSignups());
        model.addAttribute("event", event);
        
        return "form";
    }    
}
