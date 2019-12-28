/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.repository;

import org.springframework.stereotype.Repository;
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
        
        /*
                Query query = entityManager.createNativeQuery("select e.* from spring_data_jpa_example.bonus b, spring_data_jpa_example.employee e\n" +
                "where e.id = b.employee_id " +
                "and e.firstname LIKE ? " +
                "and b.amount> ? ", Employee.class);
        */
        
        System.out.println("getSignupsByName name parameter:"+name);
        //Query query = entityManager.createNativeQuery("select distinct s.* from Signup",
        //Query query = entityManager.createNativeQuery("select s.* from Signup s, Account a where s.account_id = a.id",
        //Query query = entityManager.createNativeQuery("select s.* from Signup, Account a where s.account_id = a.id",
        //Query query = entityManager.createNativeQuery("select distinct s.* from Signup s, Account a where s.account_id = a.id AND a.username ="+name,
        //Query query = entityManager.createNativeQuery("select s.* from Signup s, Account a where s.account_id = a.id AND a.username ="+name,
        
        //select s.* from Signup s, Account a where s.account_id = a.id AND a.username = '"' OR '"1=1'
        //'"' OR '1=1
        //select s.* from Signup s, Account a where s.account_id = a.id AND a.username = ''"' OR '1=1'
        //' OR '1=1
        //select s.* from Signup s, Account a where s.account_id = a.id AND a.username = '' OR '1=1'
        //""' OR '1=1
        //Query query = entityManager.createNativeQuery("select s.* from Signup s, Account a where s.account_id = a.id AND a.username = '"+name+"'",
        //this basically works:
        //Query query = entityManager.createNativeQuery("select s.* from Signup s, Account a where s.account_id = a.id AND a.username = '"+name+"' OR 1=1",
        //and to get it actually injected use: '' OR 1=1 , not working yet
        //' OR 1=1 'limit 100
        //' OR 1=1 OR name='
        
        Query query = entityManager.createNativeQuery("select s.* from Signup s, Account a where s.account_id = a.id AND a.username = '"+name+"'",
        //Query query = entityManager.createNativeQuery("select s.* from Signup s where s.account.username ="+name,
        //Query query = entityManager.createNativeQuery("select s.* from Signup s, Account a where s.account_id = a.id ",
        //Query query = entityManager.createNativeQuery("select s.* from Signup s ",
        //Query query = entityManager.createNativeQuery("select s.* from Signup s",
        //Query query = entityManager.createNativeQuery("select distinct s.* from Signup s LEFT JOIN Account a ON s.use  ",
                //"where s.username = " +name,
                //"where s.account.username = " +name,                
                //"and e.firstname LIKE ? " +
                //"and b.amount> ? ", Signup.class);
                Signup.class);
        //query.setParameter(1, firstName + "%");
        //query.setParameter(2, bonusAmount);
 
        return query.getResultList();
    }
}