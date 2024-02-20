package com.esisba.tp1_plateforme_cloud.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Server.class, name = "serverProjection")
public interface ServerInfoProjection {

    @Value("#{target.configuration.cpu}")
    String getCpu();

    @Value("#{target.configuration.ram}")
    Integer getRam();

    String getDataCenterName();
}
