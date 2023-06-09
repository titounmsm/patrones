package ayudadoc.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ayudadoc.models.curso.Curso;
import ayudadoc.models.curso.ICurso;
import ayudadoc.models.periodo.IPeriodoAcademico;
import ayudadoc.models.periodo.PeriodoAcademico;
import ayudadoc.services.CursoService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-cur")
public class CursoController {
    
    
    @Autowired
    private CursoService cursoService;

    @GetMapping("/periodo/{codigo}")
    public Mono<IPeriodoAcademico> getPeriodoAcademico(@PathVariable String codigo) {

        return cursoService.obtenerPeriodo(codigo);
    }

    @PostMapping("/periodo")
    public Mono<IPeriodoAcademico> newPeriodoAcademico(@RequestBody Map<String,Object> body) {

        return cursoService.crearPeriodo( body.get("codigo").toString(), 
                                           body.get("descripcion").toString(), 
                                           body.get("tipo").toString(), 
                                           body.get("fechaInicio").toString(), 
                                           body.get("fechaFin").toString(), 
                                           body.get("modalidad").toString() );
    }

    @PostMapping("/periodo/v2")
    public Mono<IPeriodoAcademico> newPeriodoAcademicoV2(@RequestBody PeriodoAcademico periodo) {

        return cursoService.crearPeriodo( periodo );
    }

    @PostMapping
    public Mono<ICurso> newCurso(@RequestBody Curso curso) {

        return cursoService.crearCurso( curso );
    }

    @PostMapping("/copiar")
    public Mono<ICurso> copyCurso(@RequestBody Curso curso) {

        return cursoService.copiarCurso( curso );
    }

    @GetMapping("/notas/{codigo}")
    public Mono<Curso> getNotas(@PathVariable String codigo) {

        return cursoService.mostrarNotas( Long.valueOf( codigo ) );
    }
}
