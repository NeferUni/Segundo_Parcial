package co.edu.ufps.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.entity.Usuario;
import co.edu.ufps.repository.UsuarioRepository;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setUsername(usuarioDetails.getUsername());
        final Usuario updatedUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuarioRepository.delete(usuario);
        return ResponseEntity.noContent().build();
    }
}
