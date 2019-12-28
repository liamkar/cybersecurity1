package sec.project.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sec.project.domain.Signup;

public interface SignupRepository extends JpaRepository<Signup, Long> {

    //WHERE custID='" + request.getParameter("id") + "'");
    
    @Query("SELECT s FROM Signup s where s.account.id = ?1 ")
    public List<Signup> findById(Long id);
 
    
    
}
