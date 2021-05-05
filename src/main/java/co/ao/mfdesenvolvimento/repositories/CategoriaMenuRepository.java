package co.ao.mfdesenvolvimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ao.mfdesenvolvimento.domain.CategoriaMenu;


@Repository
public interface CategoriaMenuRepository extends JpaRepository<CategoriaMenu, Integer>{

}
