package com.esisba.tp1_plateforme_cloud.API;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationDTO {

    @NotBlank(message = "CPU cannot be blank")
    private String cpu;

    @NotNull(message = "RAM cannot be null")
    @Positive(message = "RAM must be a positive value")
    private Integer ram;

    @NotBlank(message = "Disk cannot be blank")
    private Integer disk;


}
