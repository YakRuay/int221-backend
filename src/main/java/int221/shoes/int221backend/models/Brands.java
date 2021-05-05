package int221.shoes.int221backend.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Brands")
@Getter @Setter
public class Brands {
    @Id
    private int brandID;
    @NonNull
    private String brandName;
}