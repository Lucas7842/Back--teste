package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Model.UsuarioProfissional;
import org.example.Model.UsuarioProfissionalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration

public class LoadDatabase {
    Logger logger = LogManager.getLogger(this.getClass());

    @Bean
    CommandLineRunner initDatabase(UsuarioProfissionalRepository repository) {
        return args -> {
            UsuarioProfissional usuario1 = new UsuarioProfissional("Médico", "Fernanda", "(11) 9109-994", "266958", "Saúde", "Fernanda@gmail.com", "2275");
            UsuarioProfissional usuario2 = new UsuarioProfissional("Nutricionista", "Pedro", "(11) 99150-4592", "25472", "Nutrição", "Pedronutri@il.com", "2239");
            ;
            repository.saveAll(Arrays.asList(usuario1, usuario2));
            logger.info("Usuários salvos no banco de dados");

        };
    }
}
