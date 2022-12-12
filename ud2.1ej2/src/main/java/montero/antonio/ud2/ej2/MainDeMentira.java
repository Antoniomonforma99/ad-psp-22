package montero.antonio.ud2.ej2;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import montero.antonio.ud2.ej2.models.CursoOnline;
import montero.antonio.ud2.ej2.models.Profesor;
import montero.antonio.ud2.ej2.models.Videos;
import montero.antonio.ud2.ej2.repositories.CursoRepository;
import montero.antonio.ud2.ej2.repositories.ProfesorRespository;
import montero.antonio.ud2.ej2.repositories.VideosRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProfesorRespository profRepo;
    private final CursoRepository cursoRepo;

    private final VideosRepository videoRepo;

    @PostConstruct
    public void run(){

        Profesor p1 = Profesor.builder()
                .name("Luis Miguel Lopez")
                .email("luismi@luismi.luismi")
                .rating(9.9)
                .build();

        profRepo.save(p1);

        CursoOnline c1 = CursoOnline.builder()
                .name("Spring Boot MVC")
                .rating(9.5)
                .build();
        CursoOnline c2 = CursoOnline.builder()
                .name("Spring Data JPA")
                .rating(9.9)
                .build();

        List<CursoOnline> cursos = List.of(c1,c2);

        c1.addProfesor(p1);
        c2.addProfesor(p1);


        Videos v1 = Videos.builder()
                .titulo("Video 1")
                .orden("Primero")
                .descripcion("Primer video")
                .url("http:www.primervideo.com")
                .build();

        Videos v2 = Videos.builder()
                .titulo("Video 2")
                .orden("Segundo")
                .descripcion("Segundo video")
                .url("http:www.segundovideo.com")
                .build();

        List<Videos> videos = List.of(v1, v2);

        videoRepo.saveAll(videos);

        v1.addCurso(c1);
        v2.addCurso(c2);

        cursoRepo.saveAll(cursos);

        profRepo.findAll()
                .forEach(prof -> {
                    System.out.println("Profesor: " +prof.toString());
                    prof.getCursoOnlineList().forEach(System.out::println);
                });

        cursoRepo.findAll()
                .forEach(curso -> {
                    System.out.println("Curso "+curso.toString());
                    curso.getVideosList().forEach(System.out::println);
                });
    }
}
