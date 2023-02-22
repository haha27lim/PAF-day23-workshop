package sg.edu.nus.iss.app.day23workshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sg.edu.nus.iss.app.day23workshop.model.Order;
import sg.edu.nus.iss.app.day23workshop.repository.OrderRepository;

@Controller
public class IndexController {
    
    @Autowired
    private OrderRepository orderRepo;

    @GetMapping("/")
    public String searchOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "index";
    }

    @PostMapping(path="/order/total")
    public String searchOrderSubmit(@ModelAttribute Order order, Model model) {
        Order orderDetails = orderRepo.getOrderDetails(order.getOrderId());
        orderDetails.setOrderId(order.getOrderId());
        model.addAttribute("order", orderDetails);
        System.out.println(orderDetails);
        return "order_total";
    }


    @GetMapping(path="order/total/{orderId}", produces = MediaType.TEXT_HTML_VALUE)
    public String getOrderTotal (@PathVariable Integer orderId, Model model) {

        Order order = orderRepo.getOrderDetails(orderId);
        order.setOrderId(orderId);
        model.addAttribute("order", order);
        return "order_total";
    }
    
}
