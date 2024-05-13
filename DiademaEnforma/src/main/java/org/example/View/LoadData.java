package org.example.View;


import org.example.Model.Usuario;
import org.example.Model.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


@Configuration
public class LoadData {
    Logger logger = LogManager.getLogger(this.getClass());

    @Bean
    CommandLineRunner initDatabasee(UsuarioRepository repository){
        return args ->{
            Usuario usuario1 = new Usuario( "Fernanda", "Fernada Nascimento","Fernada@hotmail.com","12314","11/04/1998");

            repository.saveAll(Arrays.asList(usuario1));
            logger.info("Usuários salvos no banco de dados");
        };
    }
}
