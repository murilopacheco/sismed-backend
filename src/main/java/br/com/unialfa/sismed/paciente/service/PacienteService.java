package br.com.unialfa.sismed.paciente.service;

import br.com.unialfa.sismed.paciente.domain.Paciente;
import br.com.unialfa.sismed.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Iterable<Paciente> findAll(){
        Iterable<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes;
    }


    public Paciente savePaciente(Paciente paciente){

        return pacienteRepository.save(paciente);
    }
}
