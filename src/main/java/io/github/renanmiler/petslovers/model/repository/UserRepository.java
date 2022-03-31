package io.github.renanmiler.petslovers.model.repository;

import io.github.renanmiler.petslovers.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
