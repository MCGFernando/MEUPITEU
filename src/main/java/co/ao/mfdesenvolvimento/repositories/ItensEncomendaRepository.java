package co.ao.mfdesenvolvimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ao.mfdesenvolvimento.domain.ItensEncomenda;


@Repository
public interface ItensEncomendaRepository extends JpaRepository<ItensEncomenda, Integer>{

}
