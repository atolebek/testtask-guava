package guava.test.guavapaytask.models.delivery;


import guava.test.guavapaytask.models.User;
import jakarta.persistence.*;

@Entity
@Table(name="parcels")
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "height_mm")
    private int height;

    @Column(name = "width_mm")
    private int width;

    @Column(name = "depth_mm")
    private int depth;

    @Column(name = "weight_g")
    private int weight;

    @ManyToOne
    private Order order;

    @ManyToOne
    private User createdBy;
}
