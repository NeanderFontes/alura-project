package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medicos.dtos.DadosCadastroMedicosDTO;
import med.voll.api.domain.medicos.dtos.DadosListMedicosDTO;
import med.voll.api.domain.medicos.dtos.DadosToUpdateMedicosDTO;
import med.voll.api.domain.medicos.dtos.ResponseBodyDadosMedicosDTO;
import med.voll.api.domain.medicos.models.MedicoModel;
import med.voll.api.domain.medicos.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedicosDTO dadosMedicos,
                                    UriComponentsBuilder uriComponentsBuilder) {
        // Criando variável de um novo cadastro do object reference(MedicoModel), nova entidade no DB
        MedicoModel entityModel = repository.save(new MedicoModel(dadosMedicos));

        // Variável URI encapsulada com Location('endereço ou Header') para FrontEnd
        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(entityModel.getId()).toUri();

        // Response HttpStatus CREATED com URI e BODY do Objeto novo criado
        return ResponseEntity.created(uri).body(new ResponseBodyDadosMedicosDTO(entityModel));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListMedicosDTO>> listAll(@PageableDefault(size = 10) Pageable pageable) {
        var entityPage = repository.findAllByAtivoTrue(pageable).map(DadosListMedicosDTO::new);
        return ResponseEntity.ok(entityPage);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        MedicoModel entityModel = repository.getReferenceById(id);
        if (!entityModel.getAtivo()) {
            throw new RuntimeException("DR " + entityModel.getNome() +
                    ", CRM: " + entityModel.getCrm() + " Inativo.");
        }
        return ResponseEntity.ok(new ResponseBodyDadosMedicosDTO(entityModel));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosToUpdateMedicosDTO dadosUpdateMedicos) {
        MedicoModel entityModel = repository.getReferenceById(dadosUpdateMedicos.id());
        entityModel.updateDadosMedicos(dadosUpdateMedicos);

//        return ResponseEntity.ok(new ResponseBodyDadosMedicosDTO(entityModel));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseBodyDadosMedicosDTO(entityModel));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<Void> exclusaoLogica(@PathVariable Long id) {
        MedicoModel entityModel = repository.getReferenceById(id);
        entityModel.exclusaoLogica();

        return ResponseEntity.noContent().build();
    }
}
