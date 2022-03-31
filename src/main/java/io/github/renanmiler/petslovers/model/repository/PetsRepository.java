package io.github.renanmiler.petslovers.model.repository;

import io.github.renanmiler.petslovers.model.entity.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepository extends JpaRepository<Pets, Integer> {
}
