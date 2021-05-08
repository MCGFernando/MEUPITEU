package co.ao.mfdesenvolvimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import co.ao.mfdesenvolvimento.domain.Encomenda;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Integer>{

}
