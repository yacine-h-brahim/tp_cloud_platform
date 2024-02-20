package com.esisba.tp1_plateforme_cloud.API;

import com.esisba.tp1_plateforme_cloud.entities.Configuration;
import com.esisba.tp1_plateforme_cloud.entities.Server;
import com.esisba.tp1_plateforme_cloud.entities.User;
import com.esisba.tp1_plateforme_cloud.entities.VirtualMachine;
import com.esisba.tp1_plateforme_cloud.repositories.ServerRepository;
import com.esisba.tp1_plateforme_cloud.repositories.UserRepository;
import com.esisba.tp1_plateforme_cloud.repositories.VirtualMachineRepository;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rsu")
public class ApiController {
    @Resource
    VirtualMachineRepository virtualMachineRepository;
    @Resource
    ServerRepository serverRepository;
    @Resource
    UserRepository userRepository;

    @GetMapping("/server/{serverId}/vms")
    public List<VirtualMachine> getVMsByIdServer(@PathVariable Long serverId) {
        System.out.println("servers");
        Server server = serverRepository.findById(serverId).orElseThrow(() -> new EntityNotFoundException("Server with ID " + serverId + " not found"));
//
//
//        server.getBackupVirtualMachines();
        List<VirtualMachine> primaryVMs = server.getBackupVirtualMachines();
        List<VirtualMachine> backupVMs =server.getPrimaryVirtualMachines();

        List<VirtualMachine> allVMs = new ArrayList<>();
        allVMs.addAll(primaryVMs);
        allVMs.addAll(backupVMs);
//
        System.out.println(primaryVMs);
        System.out.println(backupVMs);
        return allVMs;
    }

    @PostMapping("/vm")
    public void SetNewVM(@RequestBody VirtualMachineDTO virtualMachineDTO) {
        //    {
//        "idUtilisateur":"1",
//            "idServeur":"2",
//            "idServeurBackup" :"1" ,
//            "configuration":{
//        "cpu":"2", "ram":"16", "disk":"100"
//    }
//    }
        try {
            VirtualMachine virtualMachine = new VirtualMachine();
            //virtual machine user
            User user = userRepository.findById(virtualMachineDTO.getUserid()).orElseThrow(() -> new EntityNotFoundException("User with ID " + virtualMachineDTO.getUserid() + " not found"));
            //servers (primary and backup)
            Server serverPrimary = serverRepository.findById(virtualMachineDTO.getServerPrimaryId()).orElseThrow(() -> new EntityNotFoundException("Primary Server with ID " + virtualMachineDTO.getServerPrimaryId() + " not found"));
            Server serverBackup = serverRepository.findById(virtualMachineDTO.getServerBackupId()).orElseThrow(() -> new EntityNotFoundException("Backup Server with ID " + virtualMachineDTO.getServerBackupId() + " not found"));
            //configuration
            Configuration configuration = new Configuration();
            configuration.setCpu(virtualMachineDTO.getConfiguration().getCpu());
            configuration.setRam(virtualMachineDTO.getConfiguration().getRam());
            configuration.setDiskSize(virtualMachineDTO.getConfiguration().getDisk()
            );

            //setting the virtual machine fields
            virtualMachine.setUser(user);
            virtualMachine.setPrimaryServer(serverPrimary);
            virtualMachine.setBackupServer(serverBackup);
            virtualMachine.setConfiguration(configuration);
            //saving to db
            virtualMachineRepository.save(virtualMachine);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();

        }


    }

    @PutMapping("/user/{id}")
    public User updateUserInfo(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new IllegalArgumentException("User with ID " + id + " not found");
        }

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return userRepository.save(user);

    }
}
