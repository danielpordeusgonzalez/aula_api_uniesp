package br.com.auloonline.api.service;

import br.com.auloonline.api.model.Aluno;
import br.com.auloonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired // faz a injeção de dados ou informações
    AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno) {
         alunoRepository.save(aluno);
    }

    public List<Aluno> buscarTodosAlunos() { return alunoRepository.findAll(); }

    public Optional<Aluno> buscarAlunoPorId(Long id) { return alunoRepository.findById(id); }

}
