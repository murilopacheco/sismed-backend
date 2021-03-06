package br.com.unialfa.sismed.paciente.rest;

import br.com.unialfa.sismed.paciente.domain.Paciente;
import br.com.unialfa.sismed.paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
@RequestMapping(path = "pacientes")
public class PacienteController {

    private final PacienteService service;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.service = pacienteService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/search/listPacientes")
    public @ResponseBody ResponseEntity<?> findAllPaciente(){
        Iterable<Paciente> pacientes = service.findAll();
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<?> savePaciente(@RequestBody Paciente paciente){
           paciente = service.save(paciente);
           if(paciente != null) {
               return ResponseEntity.ok(paciente);
           }else{
               return (ResponseEntity<?>) ResponseEntity.status(500);
           }

    }

    @PutMapping(path = "/edit")
    public @ResponseBody ResponseEntity<?> update(@RequestBody Paciente paciente){
        paciente = service.save(paciente);
        if(paciente != null) {
            return ResponseEntity.ok(paciente);
        }else{
            return (ResponseEntity<?>) ResponseEntity.status(500);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
       return service.delete(id);
    }

}
