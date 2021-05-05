package int221.shoes.int221backend.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Colors")
@Getter @Setter
public class Colors {
    @Id
    private int colorID;
    @NonNull
    private String colorName;
}
