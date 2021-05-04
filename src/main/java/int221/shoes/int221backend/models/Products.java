package int221.shoes.int221backend.models;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Products")
@Getter @Setter
public class Products {
	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    @NonNull
    private String productName;
    @NonNull
    private String productDetail;
    @NonNull
    private Date productReleaseDate;
    @NonNull
    private String productImage;
    @NonNull
    private String productPrice;

    @ManyToOne
    @JoinColumn(name="Brands_brandID")
    private Brands brandID;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "ProductColors",
            joinColumns = @JoinColumn(name = "Products_productID"),
            inverseJoinColumns = @JoinColumn(name = "Colors_colorID")
    )
    private List<Colors> colors;
}
