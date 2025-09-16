package br.com.auloonline.api.repository;

import br.com.auloonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
