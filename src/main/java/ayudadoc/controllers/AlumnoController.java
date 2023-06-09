package ayudadoc.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ayudadoc.models.alumno.AlumnoPregrado;
import ayudadoc.services.AlumnoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-alumno")
public class AlumnoController {
    @Autowired
    private AlumnoService AlumnoService;

    @GetMapping("/alumnos")
    public Flux<AlumnoPregrado> getDocentes() {
        return AlumnoService.obtenerTodos();
    }

}
