package co.ao.mfdesenvolvimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ao.mfdesenvolvimento.domain.Conta;
@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

}
