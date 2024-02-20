package com.esisba.tp1_plateforme_cloud.API;

import com.esisba.tp1_plateforme_cloud.entities.Configuration;
import com.esisba.tp1_plateforme_cloud.entities.Server;
import com.esisba.tp1_plateforme_cloud.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirtualMachineDTO {
    //    {
//        "idUtilisateur":"1",
//            "idServeur":"2",
//            "idServeurBackup" :"1" ,
//            "configuration":{
//        "cpu":"2", "ram":"16", "disk":"100"
//    }
//    }
    @NotNull
    private Long userid;
    @NotNull
    private Long serverPrimaryId;
    @NotNull
    private Long serverBackupId;
    @NotNull

    private ConfigurationDTO configuration;


}
