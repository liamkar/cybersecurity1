/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.repository;

import java.util.List;
import sec.project.domain.Signup;

/**
 *
 * @author ville
 */
//Allright, the naming of these interfaces and implementing classes is absolutely crucial, they have to correspond the signuprepository...
public interface SignupRepositoryCustom {
    //public void getSignupsByName();
    List<Signup> getSignupsByAccountUsername(String name);
}


/*
public interface EmployeeRepositoryCustom {
 
    List<Employee> getFirstNamesLikeAndBonusBigger(String firstName, Double bonusAmount);
 
}
*/

