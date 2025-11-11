package br.com.auloonline.api.service;

import br.com.auloonline.api.model.Disciplina;
import br.com.auloonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired // faz a injeção de dependencias ou informações
    DisciplinaRepository disciplinaRepository;

    public void criarDisciplina(Disciplina disciplina) {
        DisciplinaRepository.save(disciplina); // Corrigido: minusculo
    }

    public List<Disciplina> buscarTodosDisciplina() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id);
    }

    public void deletarDisciplinaPorId(Long id) { // Corrigido nome do método
        disciplinaRepository.deleteById(id); // Removido "return"
    }

    public void atualizarDisciplinaPorId(Long id, Disciplina disciplinarAtualizado) {
        Optional<Disciplina> disciplinaDoBancoDeDados = buscarDisciplinaPorId(id);

        if (disciplinaDoBancoDeDados.isEmpty()) { // Corrigido: minusculo
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, // Corrigido: NOT_FOUND
                    "Disciplina não encontrado no banco de dados");
        }

        Disciplina disciplinaParaEditar = disciplinaDoBancoDeDados.get();

        disciplinaParaEditar.setNomeCompleto(disciplinaAtualizado.getNomeCompleto());
        disciplinaParaEditar.setEmail(disciplinaAtualizado.getEmail());
        disciplinaParaEditar.setCpf(disciplinarAtualizado.getCpf());

        disciplinaRepository.save(disciplinaParaEditar);
    }
    }
}