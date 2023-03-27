package guava.test.guavapaytask.service.impl;

import guava.test.guavapaytask.dto.request.OrderCreateRequest;
import guava.test.guavapaytask.dto.request.OrderUpdateRequest;
import guava.test.guavapaytask.models.delivery.Order;
import guava.test.guavapaytask.models.delivery.OrderStatus;
import guava.test.guavapaytask.repository.OrderRepository;
import guava.test.guavapaytask.repository.UserRepository;
import guava.test.guavapaytask.service.DeliveryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Order> getOrders() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) auth.getAuthorities();
        Long userId = userRepository.findByUsername(auth.getName()).get().getId();
        if(authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))){
            return getCreatorsOrders(userId);
        }
        if(authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            return orderRepository.findAll();
        }
        return getCourierOrders(userId);
    }


    @Override
    public List<Order> getCreatorsOrders(Long id) {
        return orderRepository.findByCreator(id);
    }

    @Override
    public List<Order> getCourierOrders(Long id) {
        return orderRepository.findByCourier(id);
    }

    @Override
    public Order getOrderInfo(Long id) {
        Order o = orderRepository.findById(id).get();
        return o;
    }

    @Override
    public Order createOrder(OrderCreateRequest request) {
        Order o = new Order();
        o.setDestination(request.getDestination());
        o.setParcels(request.getParcels());
        o.setCreator(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get());
        return orderRepository.save(o);
    }

    @Override
    public Order updateOrder(Long orderId, OrderUpdateRequest request) {
        Order o = orderRepository.findById(orderId).get();
        o.setCourier(request.getCourierId() == null ? o.getCourier() : userRepository.findById(request.getCourierId()).get());
        o.setCoordinate(request.getCoordinate() == null ? o.getCoordinate() : request.getCoordinate());
        o.setDestination(request.getDestination() == null ? o.getDestination() : request.getDestination());
        return orderRepository.save(o);
    }
}
