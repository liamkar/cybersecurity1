package sec.project.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Event extends AbstractPersistable<Long> implements Comparable<Event> {

    private String name;
    //private Double price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EventSignup> eventSignups;

    public List<EventSignup> getEventSignups() {
        return eventSignups;
    }

    public void setEventSignups(List<EventSignup> eventSignups) {
        this.eventSignups = eventSignups;
    }

    
    public Event() {
    }

    public Event(String name) {
        this.name = name;        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Event o) {
        return this.name.compareTo(o.name);
    }

}
