package com.esisba.tp1_plateforme_cloud;

import com.esisba.tp1_plateforme_cloud.entities.Configuration;
import com.esisba.tp1_plateforme_cloud.entities.Server;
import com.esisba.tp1_plateforme_cloud.entities.User;
import com.esisba.tp1_plateforme_cloud.entities.VirtualMachine;
import com.esisba.tp1_plateforme_cloud.repositories.ServerRepository;
import com.esisba.tp1_plateforme_cloud.repositories.UserRepository;
import com.esisba.tp1_plateforme_cloud.repositories.VirtualMachineRepository;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp1PlateformeCloudApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Tp1PlateformeCloudApplication.class, args);
    }

    @Resource
    UserRepository userRepository;
    @Resource
    VirtualMachineRepository virtualMachineRepository;
    @Resource
    ServerRepository serverRepository;

    @Override

    public void run(String... args) throws Exception {
        User yacine = new User(null, "Yacine", "y.hadjbrahim@esi-sba.dz", null);
        User yacine2 = new User(null, "Yacine", "yacine47hb@gmail.com", null);

        Configuration vmConfiguration = new Configuration("M1", 8, 500);
        Configuration serverConfiguration = new Configuration("M1", 128, 10000);
        Server primaryServer = new Server(null, serverConfiguration, "Europe", null, null);
        Server backupServer = new Server(null, serverConfiguration, "Europe", null, null);


        VirtualMachine virtualMachine1 = new VirtualMachine(null, "Primary", vmConfiguration, yacine, backupServer, primaryServer);
        VirtualMachine virtualMachine2 = new VirtualMachine(null, "Primary", vmConfiguration, yacine, primaryServer, backupServer);

        userRepository.save(yacine);
        userRepository.save(yacine2);

        serverRepository.save(primaryServer);
        serverRepository.save(backupServer);
        virtualMachineRepository.save(virtualMachine1);
        virtualMachineRepository.save(virtualMachine2);


        userRepository.findUsersByEmailContaining("esi-sba.dz").forEach(System.out::println);
        List<Object[]> userIdAndMachineCount = virtualMachineRepository.findUserIdAndMachineCount();
        System.out.println(userIdAndMachineCount);


    }
}
