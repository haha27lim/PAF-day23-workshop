package sg.edu.nus.iss.app.day23workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import sg.edu.nus.iss.app.day23workshop.model.Order;
import sg.edu.nus.iss.app.day23workshop.repository.OrderRepository;

@RestController
@RequestMapping (path="order/total/{orderId}")
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepo;

    @GetMapping
    public ResponseEntity<Object> getOrderTotal (@PathVariable Integer orderId)  {

        Order ord = orderRepo.getOrderDetails(orderId);
        // check if the order exists        
        if (ord == null) {
            // return a 404 Not Found response if the customer does not exist
            return new ResponseEntity<>("Order with ID " + orderId + " not found", HttpStatus.NOT_FOUND);
        } // return the order with a 200 OK response
        return new ResponseEntity<>(ord, HttpStatus.OK);
    }
    
}
