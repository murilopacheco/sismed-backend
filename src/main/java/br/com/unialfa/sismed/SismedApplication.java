package br.com.unialfa.sismed;


import br.com.unialfa.sismed.paciente.domain.Paciente;
import br.com.unialfa.sismed.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class SismedApplication {

	@Autowired
	private PacienteRepository pacienteRepository;


	public static void main(String[] args) {
		SpringApplication.run(SismedApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		Paciente paciente = new Paciente();
		paciente.setCpf("01446294102");
		paciente.setNome("Murilo");
		paciente.setEmail("murilo@murilo.com");
		paciente.setDataNascimento(LocalDate.of(1985,01,01));
		pacienteRepository.save(paciente);
		return null;
	}


}
