package guava.test.guavapaytask.service;

import guava.test.guavapaytask.dto.request.OrderCreateRequest;
import guava.test.guavapaytask.dto.request.OrderUpdateRequest;
import guava.test.guavapaytask.models.delivery.Order;
import guava.test.guavapaytask.models.delivery.OrderStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DeliveryService {
    List<Order> getOrders();
    List<Order> getCreatorsOrders(Long id);

    List<Order> getCourierOrders(Long id);

    Order getOrderInfo(Long id);

    Order updateOrder(Long id, OrderUpdateRequest request);

    Order createOrder(OrderCreateRequest request);
}
