package com.CENIGRAF.GestorMateriales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestorMaterialesApplication implements CommandLineRunner{

	@Autowired
        private BCryptPasswordEncoder passEncoder;
        
        
        public static void main(String[] args) {
            SpringApplication.run(GestorMaterialesApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        
        var pass1="admin";
        
        System.out.println(passEncoder.encode(pass1));
    }

}
