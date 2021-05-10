package int221.shoes.int221backend.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Colors")
@Getter
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int colorID;
    @NonNull
    private String colorName;
}
