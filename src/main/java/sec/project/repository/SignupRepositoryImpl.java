/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.repository;

import org.springframework.transaction.annotation.Transactional;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import sec.project.domain.Signup;
 
/**
 *
 * @author ville
 */

@Transactional(readOnly = true)
public class SignupRepositoryImpl implements SignupRepositoryCustom {
 
    @PersistenceContext
    EntityManager entityManager;
 
    @Override
    public List<Signup> getSignupsByAccountUsername(String name) {
        
        //this basically works:
        //Query query = entityManager.createNativeQuery("select s.* from Signup s, Account a where s.account_id = a.id AND a.username = '"+name+"' OR 1=1",
        //and to get it actually injected use: ' OR 1=1 OR name='
        
        Query query = entityManager.createNativeQuery("select s.* from Signup s, Account a where s.account_id = a.id AND a.username = '"+name+"'",
                Signup.class);
 
        return query.getResultList();
    }
}