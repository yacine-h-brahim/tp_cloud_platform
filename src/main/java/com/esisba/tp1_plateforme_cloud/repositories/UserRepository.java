package com.esisba.tp1_plateforme_cloud.repositories;

import com.esisba.tp1_plateforme_cloud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUsersByEmailContaining(String domain);

}
