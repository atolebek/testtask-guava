package guava.test.guavapaytask.models.delivery;

import guava.test.guavapaytask.models.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order")
    private Set<Parcel> parcels;

    private String coordinate;

    private OrderStatus status;

    private String destination;

    @ManyToOne
    private User courier;

    @ManyToOne
    private User creator;
}
