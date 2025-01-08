package workshop.paf_23w.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import workshop.paf_23w.model.Order;
import workshop.paf_23w.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Optional<Order> getOrderDetails(int oid) {
        return repository.getOrderDetails(oid);
    }
    
}
