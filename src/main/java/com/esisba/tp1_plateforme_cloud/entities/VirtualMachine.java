package com.esisba.tp1_plateforme_cloud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VirtualMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Embedded
    @Basic(fetch = FetchType.LAZY)
    private Configuration configuration;

    @ManyToOne
    private User user;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "primary_server_id")
    private Server primaryServer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "backup_server_id")
    private Server backupServer;


}
