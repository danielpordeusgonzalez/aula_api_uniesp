package br.com.auloonline.api.service;

import br.com.auloonline.api.model.Professor;
import br.com.auloonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired // faz a injeção de dados ou informações
    ProfessorRepository professorRepository;

    public void criarProfessor(Professor professor) {
        professorRepository.save(professor); // Corrigido: minusculo
    }

    public List<Professor> buscarTodosProfessor() {
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarProfessorPorId(Long id) {
        return professorRepository.findById(id);
    }

    public void deletarProfessorPorId(Long id) { // Corrigido nome do método
        professorRepository.deleteById(id); // Removido "return"
    }

    public void atualizarProfessorPorId(Long id, Professor professorAtualizado) {
        Optional<Professor> professorDoBancoDeDados = buscarProfessorPorId(id);

        if (professorDoBancoDeDados.isEmpty()) { // Corrigido: minusculo
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, // Corrigido: NOT_FOUND
                    "Professor não encontrado no banco de dados");
        }

        Professor professorParaEditar = professorDoBancoDeDados.get();

        professorParaEditar.setNomeCompleto(professorAtualizado.getNomeCompleto());
        professorParaEditar.setEmail(professorAtualizado.getEmail());
        professorParaEditar.setCpf(professorAtualizado.getCpf());

        professorRepository.save(professorParaEditar);
    }
}