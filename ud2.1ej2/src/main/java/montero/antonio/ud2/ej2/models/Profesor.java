package montero.antonio.ud2.ej2.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;

    private String name, email;

    private Double rating;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    private List<CursoOnline> cursoOnlineList = new ArrayList<>();

    @PreRemove
    public void setNullCurso(){
        cursoOnlineList.forEach(c -> c.setProfesor(null));

    }

}
