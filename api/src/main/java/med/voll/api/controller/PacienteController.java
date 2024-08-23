package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.pacientes.dtos.DadosCadastroPacientesDTO;
import med.voll.api.pacientes.dtos.DadosListPacientesDTO;
import med.voll.api.pacientes.dtos.DadosToUpdatePacientesDTO;
import med.voll.api.pacientes.models.PacientesModel;
import med.voll.api.pacientes.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPacientesDTO dadosPacientesDTO) {
        repository.save(new PacientesModel(dadosPacientesDTO));
    }

    @GetMapping("/pageable")
    public Page<DadosListPacientesDTO> listAllPageable(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageableAll) {
        return repository.findAllByAtivoTrue(pageableAll).map(DadosListPacientesDTO::new);
    }

    @GetMapping
    public List<DadosListPacientesDTO> listall() {
        return repository.findAll().stream().map(DadosListPacientesDTO::new).toList();
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DadosToUpdatePacientesDTO dadosUpdatePacientes) {
        PacientesModel entityPaciente = repository.getReferenceById(dadosUpdatePacientes.id());
        entityPaciente.updateDadosPacientes(dadosUpdatePacientes);
    }

    @DeleteMapping(value = "/dadosFromDB/{id}")
    @Transactional
    public void deleteFromDB(@PathVariable Long id) {
        PacientesModel entityDelete = repository.findById(id).orElseThrow();
        repository.delete(entityDelete);
    }

//    @DeleteMapping(value = "/exclusaoLogica/{id}")
//    @Transactional
//    public void delete(@PathVariable Long id) {
//        PacientesModel entityDelete = repository.getReferenceById(id);
//        entityDelete.exclusaoLogica();
//    }

    @DeleteMapping(value = "/exclusaoLogica/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        PacientesModel entityDelete = repository.findById(id).orElseThrow();
        entityDelete.exclusaoLogica();
    }
}
