package montero.antonio.ud2.ej1.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private Double pvp;

    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_CATEGORY"))
    private Category category;

    public void addCategory(Category c) {
        this.category = c;
        c.getProducts().add(this);
    }

    public void removeCategory(Category c) {
        c.getProducts().remove(this);
        this.category =  null;
    }
}
