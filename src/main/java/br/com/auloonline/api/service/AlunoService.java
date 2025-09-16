package br.com.auloonline.api.service;

import br.com.auloonline.api.model.Aluno;
import br.com.auloonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;


    public void criarAluno(Aluno aluno) {
         alunoRepository.save(aluno);
    }
}
