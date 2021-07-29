package br.com.zup.edu.nossositedeviagens.Repository;

import br.com.zup.edu.nossositedeviagens.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
