/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Event;
import sec.project.repository.EventRepository;
    

/**
 *
 * @author ville
 */
@Controller
public class EventController {
   
    /*
    private List<String> events;

    public EventController() {
        this.events = new ArrayList<>();
        this.events.add("Bike tour around Helsinki!");
        this.events.add("Moonlight Half Marathon");
        this.events.add("Jukolan viesti");
        this.events.add("Tour de ski");
    }
    */

  /*
    package sec.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sec.webshop.repository.ItemRepository;
*/
    
    /*
@Controller
public class ItemController {
*/
    
    
    
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        //model.addAttribute("events", events);
        return "events";
    }
    
    @RequestMapping(value = "/events/{eventId}", method = RequestMethod.GET)
    public String eventSignups(@PathVariable Long eventId, Model model) {
        //shoppingCart.addToCart(itemRepository.findOne(itemId));
        //return "redirect:/cart";
        
        Event event = eventRepository.getOne(eventId);
        
        
        //model.addAttribute("signups", eventRepository.getOne(eventId));
        model.addAttribute("signups", event.getEventSignups());
        model.addAttribute("event", event);
        
        return "form";
    }

    
    
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


