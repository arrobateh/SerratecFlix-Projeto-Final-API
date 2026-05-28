package org.serratec.SerratecFlix.config;

import org.serratec.SerratecFlix.domain.Usuario;
import org.serratec.SerratecFlix.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DadosIniciaisConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        String emailAdmin = "admin@serratec.org";

        // Verificação se o admin já existe
        if (usuarioRepository.findByEmail(emailAdmin).isEmpty()) {
            Usuario admin = new Usuario();
            admin.setNome("Admin");
            admin.setEmail(emailAdmin);
            admin.setUsername("admin");

            admin.setSenha(passwordEncoder.encode("admin")); // Senha padrão para o admin

            admin.setPerfil("ROLE_ADMIN");

            usuarioRepository.save(admin);
        }
    }

}
