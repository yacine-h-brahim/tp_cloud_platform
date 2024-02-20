package com.esisba.tp1_plateforme_cloud.repositories;

import com.esisba.tp1_plateforme_cloud.entities.Server;
import com.esisba.tp1_plateforme_cloud.entities.ServerInfoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ServerRepository extends JpaRepository<Server, Long> {
    List<ServerInfoProjection> findServerInfoProjectionBy();

}
