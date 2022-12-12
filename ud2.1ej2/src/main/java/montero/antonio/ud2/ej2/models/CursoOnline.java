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
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double rating;

    @ManyToOne
    @JoinColumn(name= "profesor_id", foreignKey = @ForeignKey(name = "FK_CURSO_PROFESOR"))
    private Profesor profesor;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    private List<Videos> videosList = new ArrayList<>();

    @PreRemove
    public void setNullVideo() {
        videosList.forEach(v -> v.setCurso(null));
    }



    public void addProfesor(Profesor p) {
        this.profesor = p;
        p.getCursoOnlineList().add(this);
    }

    public void removeProfesor(Profesor p) {
        p.getCursoOnlineList().remove(this);
        this.profesor = null;
    }
}
