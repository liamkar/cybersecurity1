/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import sec.project.domain.Event;
import sec.project.domain.Signup;

/**
 *
 * @author ville
 */
@Service
public class SignupService {
/*    
    SignupRepository
    
    @Transactional
    public void addSignup(Event event, String name, String address) {

        Signup signup = new Signup();
        signup.setName(name);
        signup.setAddress(address);

        List<OrderItem> items = new ArrayList<>();
        for (Item item : shoppingCart.getItems().keySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(itemRepository.findOne(item.getId()));
            orderItem.setItemCount(shoppingCart.getItems().get(item));

            items.add(orderItem);
        }

        order.setOrderItems(items);

        orderRepository.save(order);
        shoppingCart.getItems().clear();
    }
  */  
    
}
