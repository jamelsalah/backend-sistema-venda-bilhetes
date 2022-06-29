package src.rest.api.repository;

import src.rest.api.model.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    @Query(value="SELECT * FROM users WHERE login = :login", nativeQuery = true)
    public UsuarioModel registerAuth(String login);

    @Query(value="INSERT INTO users (login, password) VALUES (login, password)", nativeQuery = true)
    public int register(UsuarioModel usuario);
}
