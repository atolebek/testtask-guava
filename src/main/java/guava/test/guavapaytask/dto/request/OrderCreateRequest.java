package guava.test.guavapaytask.dto.request;

import guava.test.guavapaytask.models.delivery.OrderStatus;
import guava.test.guavapaytask.models.delivery.Parcel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateRequest {
    private Set<Parcel> parcels;
    private String destination;
    private OrderStatus status = OrderStatus.CREATED;
}
