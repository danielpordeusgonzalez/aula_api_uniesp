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

    @GetMappin
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> buscarTodosProfessores() {
            return professorService.buscarTodosProfessor();
        }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Professor> buscarProfessorPorId(@PathVariable Long id) {
        return professorService.buscarProfessorPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProfessorPorId(@PathVariable Long id) {
            professorService.deletarProfessorPorId(id);
        }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarProfessorPorId(@PathVariable Long id, @RequestBody Professor professorAtualizado) {
        professorService.atualizarProfessorPorId(id, professorAtualizado);
    }