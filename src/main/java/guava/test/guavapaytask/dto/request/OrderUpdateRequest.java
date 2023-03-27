package guava.test.guavapaytask.dto.request;

import guava.test.guavapaytask.models.delivery.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUpdateRequest {
    private Long courierId;
    private String destination;
    private String coordinate;
    private OrderStatus status;
}
