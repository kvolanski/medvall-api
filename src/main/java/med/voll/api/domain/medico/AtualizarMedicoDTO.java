package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.EnderecoDTO;

public record AtualizarMedicoDTO(

        @NotNull
        Long id,

        String nome,

        String telefone,

        EnderecoDTO enderecoDTO) {

}
