package montero.antonio.ud2.ej2.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Videos {

    @Id @GeneratedValue
    private Long id;

    private String orden, titulo, descripcion, url;

    @ManyToOne
    @JoinColumn(name = "curso_id", foreignKey = @ForeignKey(name = "FK_VIDEO_CURSO"))
    private CursoOnline curso;

    public void addCurso(CursoOnline c) {
        this.curso = c;
        c.getVideosList().add(this);
    }

    public void removeCurso(CursoOnline c) {
        c.getVideosList().remove(this);
        this.curso = null;
    }

}
