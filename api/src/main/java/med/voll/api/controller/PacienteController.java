package med.voll.api.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import med.voll.api.domain.pacientes.dtos.DadosCadastroPacientesDTO;
import med.voll.api.domain.pacientes.dtos.DadosListPacientesDTO;
import med.voll.api.domain.pacientes.dtos.DadosToUpdatePacientesDTO;
import med.voll.api.domain.pacientes.dtos.ResponseBodyDadosPacientesDTO;
import med.voll.api.domain.pacientes.models.PacientesModel;
import med.voll.api.domain.pacientes.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseBodyDadosPacientesDTO> cadastrar(@RequestBody @Valid DadosCadastroPacientesDTO dadosPacientesDTO,
                                                               UriComponentsBuilder uriComponentsBuilder) {
        // Criando variável de um novo cadastro do objeto reference(PacientesModel), nova entidade no DB
        var entityModel = repository.save(new PacientesModel(dadosPacientesDTO));

        // Componente de URI encapsulada com Location('endereço ou header') para FrontEnd
        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(entityModel.getId()).toUri();

        // Response HttpStatus 201 com URI e BODY do Objeto novo criado
        return ResponseEntity.created(uri).body(new ResponseBodyDadosPacientesDTO(entityModel));
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<DadosListPacientesDTO>> listAllPageable(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageableAll) {
        // Criando PageList de DadosListPacientesDTO
        var entityPageList = repository.findAllByAtivoTrue(pageableAll).map(DadosListPacientesDTO::new);

        // Response HttpStatus 200 com o 'BODY ou CORPO' da Lista de Objetos
        return ResponseEntity.ok(entityPageList);
    }

    @GetMapping
    public ResponseEntity<List<DadosListPacientesDTO>> listall() {
        //Criando List de DadosListPacientesDTO
        var entityList = repository.findAll().stream().map(DadosListPacientesDTO::new).toList();

        // Response HttpStatus 200 com o 'BODY ou CORPO' da Lista de Objetos
        return ResponseEntity.ok(entityList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseBodyDadosPacientesDTO> getById(@PathVariable Long id) {
        // Buscando por Id o Object Reference('PacientesModel')
        var entityModel = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com ID: " + id));

        // Response HttpStatus 200 com Lista dos dados do ID recuperado no DB
        return ResponseEntity.ok(new ResponseBodyDadosPacientesDTO(entityModel));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ResponseBodyDadosPacientesDTO> update(@RequestBody @Valid DadosToUpdatePacientesDTO dadosUpdatePacientes) {
        // Buscando por id Object Reference('PacientesModel')
        PacientesModel entityPaciente = repository.getReferenceById(dadosUpdatePacientes.id());

        // Implementação de Método para UPDATE em 'DadosToUpdatePacientesDTO' do ID('PacienteModel')
        entityPaciente.updateDadosPacientes(dadosUpdatePacientes);

        // Response HttpStatus 200 com 'BODY ou CORPO' dos dados alterados e completos da entidade
        return ResponseEntity.ok().body(new ResponseBodyDadosPacientesDTO(entityPaciente));
    }

    @DeleteMapping(value = "/dadosFromDB/{id}")
    @Transactional
    public ResponseEntity<Void> deleteFromDB(@PathVariable Long id) {
        // Buscando por id Object Reference('PacientesModel')
        PacientesModel entityDelete = repository.findById(id).orElseThrow();

        // Delete do ID no bando de dados
        repository.delete(entityDelete);

        // Response 201 para confirmação de NoContent
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/exclusaoLogica/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // Buscando por id Object Reference('PacientesModel')
        PacientesModel entityDelete = repository.findById(id).orElseThrow();

        // Delete do ID da esclusão lógica
        entityDelete.exclusaoLogica();

        // Response 201 para confirmação de NoContent
        return ResponseEntity.noContent().build();
    }
}
