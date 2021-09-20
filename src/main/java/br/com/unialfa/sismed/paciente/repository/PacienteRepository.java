package br.com.unialfa.sismed.paciente.repository;


import br.com.unialfa.sismed.paciente.domain.Paciente;
import org.springframework.data.repository.CrudRepository;;


public interface PacienteRepository extends CrudRepository<Paciente, Long> {

}
