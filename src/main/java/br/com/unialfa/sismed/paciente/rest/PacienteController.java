package br.com.unialfa.sismed.paciente.rest;

import br.com.unialfa.sismed.paciente.domain.Paciente;
import br.com.unialfa.sismed.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
@RequestMapping(path = "pacientes")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/search/listPacientes")
    public @ResponseBody ResponseEntity<?> findAllPaciente(){
        Iterable<Paciente> pacientes = pacienteRepository.findAll();
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<?> savePaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteRepository.save(paciente));
    }

    @PutMapping(path = "/edit")
    public @ResponseBody ResponseEntity<?> updatePaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteRepository.save(paciente));
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody ResponseEntity<?> deletePaciente(@PathVariable(name = "id") Long id){
       try {
           pacienteRepository.deleteById(id);
           return ResponseEntity.ok(true);
       }catch (Exception e){
           return (ResponseEntity<?>) ResponseEntity.status(500);
       }

    }

}
