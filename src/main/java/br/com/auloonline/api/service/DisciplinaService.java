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
        disciplinaRepository.save(disciplina); // Corrigido: minusculo
    }

    public List<Disciplina> buscarTodasDisciplinas() { // Corrigido nome do método
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id);
    }

    public void deletarDisciplinaPorId(Long id) {
        disciplinaRepository.deleteById(id);
    }

    public void atualizarDisciplinaPorId(Long id, Disciplina disciplinaAtualizada) { // Corrigido nome do parâmetro
        Optional<Disciplina> disciplinaDoBancoDeDados = buscarDisciplinaPorId(id);

        if (disciplinaDoBancoDeDados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, // Corrigido: adicionada a vírgula faltante
                    "Disciplina não encontrada no banco de dados"); // Corrigido mensagem
        }

        Disciplina disciplinaParaEditar = disciplinaDoBancoDeDados.get();

        disciplinaParaEditar.setNome(disciplinaAtualizada.getNome());

        disciplinaRepository.save(disciplinaParaEditar);
    }
}