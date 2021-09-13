package br.com.unialfa.sismed.convenio.domain;

import br.com.unialfa.sismed.paciente.domain.Paciente;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//anotations lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
// anotation jpa
@Entity
public class Convenio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String registoAns;
    private String telefone;

    @OneToMany
    List<Paciente> pacientes;
}
