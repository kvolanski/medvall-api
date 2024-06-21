package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    @Embedded
    private Endereco endereco;

    public Paciente(CadastroPacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.nome();
        this.email = pacienteDTO.email();
        this.telefone = pacienteDTO.telefone();
        this.endereco = new Endereco(pacienteDTO.endereco());
    }

    public void atualizar(AtualizarPacienteDTO atualizarPacienteDTO) {
        if (atualizarPacienteDTO.nome() != null){
            this.nome = atualizarPacienteDTO.nome();
        }

        if (atualizarPacienteDTO.email() != null){
            this.email = atualizarPacienteDTO.email();
        }

        if(this.telefone != null){
            this.telefone = atualizarPacienteDTO.telefone();
        }

        if (atualizarPacienteDTO.enderecoDTO() != null){
            this.endereco.atualizar(atualizarPacienteDTO.enderecoDTO());
        }
    }
}
