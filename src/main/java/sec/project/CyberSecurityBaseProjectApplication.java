package sec.project;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import sec.project.domain.Event;
import sec.project.repository.EventRepository;

@SpringBootApplication
public class CyberSecurityBaseProjectApplication {

    @Autowired
    private EventRepository eventRepository;
    
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(CyberSecurityBaseProjectApplication.class);
    }
    
    
    @Bean
    InitializingBean sendDatabase() {
    return () -> {
        eventRepository.save(new Event("Bike tour around Helsinki"));
        eventRepository.save(new Event("Jukola"));
        eventRepository.save(new Event("Tour de ski"));
        eventRepository.save(new Event("Half marathon - moonlight mile"));
      };
   }
    
}



