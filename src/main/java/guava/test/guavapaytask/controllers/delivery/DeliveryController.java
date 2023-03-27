package guava.test.guavapaytask.controllers.delivery;

import guava.test.guavapaytask.dto.request.OrderCreateRequest;
import guava.test.guavapaytask.dto.request.OrderUpdateRequest;
import guava.test.guavapaytask.models.delivery.Order;
import guava.test.guavapaytask.models.delivery.OrderStatus;
import guava.test.guavapaytask.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @PostMapping("/orders")
    public Order createOrder(@RequestBody OrderCreateRequest request){
        return deliveryService.createOrder(request);
    }

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return deliveryService.getOrders();
    }

    @GetMapping("/orders/{orderId}")
    public Order getOrderInfo(@PathVariable("orderId") Long orderId){
        return deliveryService.getOrderInfo(orderId);
    }

    @PutMapping("/orders/{orderId}")
    @PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
    public ResponseEntity updateStatus(@PathVariable("orderId") Long orderId, @RequestBody OrderStatus status){
        OrderUpdateRequest o = new OrderUpdateRequest();
        o.setStatus(status);
        deliveryService.updateOrder(orderId, o);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/orders/{id}/destination/{destination}")
    @PreAuthorize("hasRole('USER')")
    public Order updateDestination(@PathVariable Long orderId, @RequestBody OrderUpdateRequest request){
        return deliveryService.updateOrder(orderId, request);
    }

}
