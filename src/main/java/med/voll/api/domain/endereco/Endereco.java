package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizar(EnderecoDTO enderecoDTO) {

        if (enderecoDTO.logradouro() != null) {
            this.logradouro = enderecoDTO.logradouro();
        }
        if (enderecoDTO.bairro() != null) {
            this.bairro = enderecoDTO.bairro();
        }
        if (enderecoDTO.cep() != null) {
            this.cep = enderecoDTO.cep();
        }
        if (enderecoDTO.uf() != null) {
            this.uf = enderecoDTO.uf();
        }
        if (enderecoDTO.cidade() != null) {
            this.cidade = enderecoDTO.cidade();
        }
        if (enderecoDTO.numero() != null) {
            this.numero = enderecoDTO.numero();
        }
        if (enderecoDTO.complemento() != null) {
            this.complemento = enderecoDTO.complemento();
        }

    }
}
