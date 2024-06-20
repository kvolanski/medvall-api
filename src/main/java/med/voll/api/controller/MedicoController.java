package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public String cadastrar(@RequestBody @Valid CadastroMedicoDTO cadastroMedicoDTO){
        medicoRepository.save(new Medico(cadastroMedicoDTO));
        return "Cadastrado com sucesso.";
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size=10,sort = {"nome"}) Pageable pageable){
        return medicoRepository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarMedicoDTO atualizarMedicoDTO){
        var medico = medicoRepository.getReferenceById(atualizarMedicoDTO.id());
        medico.atualizar(atualizarMedicoDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }

}
