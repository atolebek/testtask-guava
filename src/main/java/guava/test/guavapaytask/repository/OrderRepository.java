package guava.test.guavapaytask.repository;

import guava.test.guavapaytask.models.delivery.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);
    List<Order> findByCourier(Long courierId);

    List<Order> findByCreator(Long creatorId);
}
