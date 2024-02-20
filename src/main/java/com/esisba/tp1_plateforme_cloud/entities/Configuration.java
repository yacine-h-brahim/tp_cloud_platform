package com.esisba.tp1_plateforme_cloud.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Configuration {
    @Basic(fetch = FetchType.EAGER)
    private String cpu;

    @Basic(fetch = FetchType.EAGER)
    private Integer ram;

    @Basic(fetch = FetchType.EAGER)
    private Integer diskSize;
}
