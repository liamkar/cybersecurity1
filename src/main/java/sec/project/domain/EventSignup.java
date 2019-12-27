/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author ville
 */
@Entity
public class EventSignup extends AbstractPersistable<Long> {
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Signup signup;
    private Long itemCount;

    public Signup getSingup() {
        return signup;
    }

    public void setSignup(Signup signup) {
        this.signup = signup;
    }

    public Long getItemCount() {
        return itemCount;
    }

    public void setItemCount(Long itemCount) {
        this.itemCount = itemCount;
    }

}
