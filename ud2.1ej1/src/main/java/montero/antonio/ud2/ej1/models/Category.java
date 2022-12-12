package montero.antonio.ud2.ej1.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor  @AllArgsConstructor
@Builder
public class Category {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "fatherCat_id", foreignKey = @ForeignKey(name = "FK_FATHER_CAT"))
    private Category FatherCat;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    @PreRemove
    public void setNullProducts(){
        products.forEach(p -> p.setCategory(null));
    }


}
