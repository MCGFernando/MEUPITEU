package co.ao.mfdesenvolvimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import co.ao.mfdesenvolvimento.domain.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer>{

}
