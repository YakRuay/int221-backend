package int221.shoes.int221backend.models;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "Products")
@Getter @Setter
public class Products {
	@Id
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
