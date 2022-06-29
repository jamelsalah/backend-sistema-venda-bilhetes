package src.rest.api.controller;

import src.rest.api.model.UsuarioModel;
import src.rest.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

//    @GetMapping(path = "/api/usuario/{codigo}")
//    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
//        return repository.findById(codigo)
//                .map(record -> ResponseEntity.ok().body(record))
//                .orElse(ResponseEntity.notFound().build());
//    }

    @PostMapping(path = "/api/usuario/register")
    public UsuarioModel register(@RequestBody UsuarioModel usuario) {
        UsuarioModel x = repository.registerAuth(usuario.getLogin());

        repository.save(usuario);
        return usuario;

    }

}
