package net.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.springboot.backend.model.Godown;


@Repository
public interface SuperCategoryRepository extends JpaRepository<Godown, Long>{

}
