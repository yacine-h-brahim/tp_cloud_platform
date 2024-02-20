package com.esisba.tp1_plateforme_cloud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Basic(fetch = FetchType.EAGER)
    private Configuration configuration;

    @Column
    private String dataCenterName;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "primaryServer")
    private List<VirtualMachine> primaryVirtualMachines;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "backupServer")
    private List<VirtualMachine> backupVirtualMachines;


}
