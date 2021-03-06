package int221.shoes.int221backend.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Brands")
@Getter
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandID;
    @NonNull
    private String brandName;
}