package com.esisba.tp1_plateforme_cloud.API;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String email;
}
