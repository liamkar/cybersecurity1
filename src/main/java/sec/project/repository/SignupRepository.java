package sec.project.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sec.project.domain.Signup;

@Repository
public interface SignupRepository extends JpaRepository<Signup, Long>, SignupRepositoryCustom {

    
    
    //it's pretty damn hard and frustrating trying to create injection vulnerability with these tools
    //there seems to be no way. So in order to get the ecerise done, it seems we need to fall back to completely
    //diffrenet set of techniques very laborous and unmotivating work but maybe people wiser than me see
    //that it will help us learning
    
    //@Query("SELECT s FROM Signup s where s.account.id = ?1 ")
    //@Query("SELECT s FROM Signup s where s.account.username = "+name)
    //public List<Signup> findById(Long id);
    //public List<Signup> findById();
    //public List<Signup> findByName(String name);
    
    
    //let's try with some ancient toolings to create injectio vulnerability
    //EntityManager em = emf.createEntityManager();
    //List<Object> results = em.createNativeQuery("SELECT custom FROM my_data").getResultList();
    //List<Signup> signups = em.createNativeQuery("SELECT * FROM Signup").getResultList();
    
    
 /*   
    //WHERE custID='" + request.getParameter("id") + "'");
    
    @Query("SELECT s FROM Signup s where s.account.id = ?1 ")
    public List<Signup> findById(Long id);
 
    EntityManager em
    Query q = em.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a");
List<Object[]> authors = q.getResultList();
 
for (Object[] a : authors) {
    System.out.println("Author "
            + a[0]
            + " "
            + a[1]);
}
   */ 
    
}
