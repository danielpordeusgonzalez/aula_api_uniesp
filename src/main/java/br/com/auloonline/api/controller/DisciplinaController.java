package br.com.auloonline.api.controller;

import br.com.auloonline.api.model.Disciplina;
import br.com.auloonline.api.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarDisciplina(@RequestBody Disciplina disciplina) {
        disciplinaService.criarDisciplina(disciplina);
    } // Faltava fechar este método

    @GetMapping // Corrigido o nome da anotação
    @ResponseStatus(HttpStatus.OK)
    public List<Disciplina> buscarTodasDisciplinas() {
        return disciplinaService.buscarTodasDisciplinas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Disciplina> buscarDisciplinaPorId(@PathVariable Long id) {
        return disciplinaService.buscarDisciplinaPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarDisciplinaPorId(@PathVariable Long id) {
        disciplinaService.deletarDisciplinaPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDisciplinaPorId(@PathVariable Long id, @RequestBody Disciplina disciplinaAtualizada) { // Corrigido o tipo do parâmetro
        disciplinaService.atualizarDisciplinaPorId(id, disciplinaAtualizada); // Corrigido o nome do método
    }
}