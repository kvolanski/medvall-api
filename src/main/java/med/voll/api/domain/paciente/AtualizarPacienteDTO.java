package med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.EnderecoDTO;

public record AtualizarPacienteDTO(

        @NotNull
        Long id,
        String nome,

        String email,

        String telefone,

        EnderecoDTO enderecoDTO) {

}
