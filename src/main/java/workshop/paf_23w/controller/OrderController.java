package workshop.paf_23w.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import workshop.paf_23w.model.Order;
import workshop.paf_23w.service.OrderService;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/total/{oid}")
    @ResponseBody
    public String getTotal(@PathVariable("oid") String oid) throws Exception {
        Optional<Order> o = service.getOrderDetails(Integer.parseInt(oid));
        return o.map(order -> Double.toString(order.getTotal()))
            .orElseThrow(() -> new Exception("Order not found."));
    }
    
}
