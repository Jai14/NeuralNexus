package com.NeuralNexus.Group.project.repo;

import com.NeuralNexus.Group.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository <User,Long>{
    boolean existsByEmail(String email);
}
