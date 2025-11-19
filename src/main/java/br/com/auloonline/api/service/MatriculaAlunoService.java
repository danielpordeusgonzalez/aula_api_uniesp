package br.com.auloonline.api.service;

import br.com.auloonline.api.model.MatriculaAluno;
import br.com.auloonline.api.model.MatriculaStatusEnum; // Import adicionado
import br.com.auloonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaAlunoService {

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    public void matricular(MatriculaAluno matriculaAluno) {
        matriculaAluno.setStatus(MatriculaStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(matriculaAluno);
    }
}