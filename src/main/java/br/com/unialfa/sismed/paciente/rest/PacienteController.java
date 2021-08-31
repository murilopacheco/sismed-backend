package br.com.unialfa.sismed.paciente.rest;

import br.com.unialfa.sismed.paciente.domain.Paciente;
import br.com.unialfa.sismed.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Paciente> findAllPaciente(){
        return pacienteRepository.findAll();
    }

    @PostMapping(path = "/add")
    public Paciente savePaciente(@RequestBody Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    @PutMapping(path = "/edit")
    public Paciente updatePaciente(@RequestBody Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deletePaciente(@PathVariable(name = "id") Long id){
        pacienteRepository.deleteById(id);
    }

}
