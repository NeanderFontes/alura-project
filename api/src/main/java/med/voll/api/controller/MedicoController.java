package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medicos.dtos.DadosCadastroMedicosDTO;
import med.voll.api.medicos.dtos.DadosListMedicosDTO;
import med.voll.api.medicos.dtos.DadosToUpdateMedicosDTO;
import med.voll.api.medicos.models.MedicoModel;
import med.voll.api.medicos.repositories.MedicoRepository;
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
    private MedicoRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicosDTO dadosMedicos) {
        repository.save(new MedicoModel(dadosMedicos));
    }

    @GetMapping
    public Page<DadosListMedicosDTO> listAll(@PageableDefault(size = 10) Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(DadosListMedicosDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosToUpdateMedicosDTO dadosUpdateMedicos) {
        MedicoModel entityModel = repository.getReferenceById(dadosUpdateMedicos.id());
        entityModel.updateDadosMedicos(dadosUpdateMedicos);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public void exclusaoLogica(@PathVariable Long id) {
        MedicoModel entityModel = repository.getReferenceById(id);
        entityModel.exclusaoLogica();
    }

}
