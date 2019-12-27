package sec.project.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ville
 */

import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
