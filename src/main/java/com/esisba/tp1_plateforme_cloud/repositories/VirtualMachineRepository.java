package com.esisba.tp1_plateforme_cloud.repositories;

import com.esisba.tp1_plateforme_cloud.entities.VirtualMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface
VirtualMachineRepository extends JpaRepository<VirtualMachine, Long> {
    @Query("SELECT v.user.id AS userId, COUNT(v) AS machineCount FROM VirtualMachine v GROUP BY v.user.id")
    List<Object[]> findUserIdAndMachineCount();

//    List<VirtualMachine> findByPrimaryServerId(Long primaryServerId);
//
//    List<VirtualMachine> findByBackupServerId(Long backupServerId);
}
