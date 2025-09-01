package org.miempresa.vacas.services;

import lombok.*;
import org.miempresa.vacas.models.Usuario;
import org.miempresa.vacas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServices {
    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodosUsuarios(){
        return usuarioRepository.findAll();
    }
    public Usuario obtenerPorId(Integer id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
    public Usuario guardarUsuario(Usuario usuario){
        if (usuarioRepository.existsUsuarioByNroCedula(usuario.getNroCedula())){
            throw new RuntimeException("Usuario ya existe");
        }
        return usuarioRepository.save(usuario);
    }
    @Transactional
    public void actualizarUsuario(Integer id_usuario, String nombre, String apellido, String correo){
        usuarioRepository.actualizarUsuario(id_usuario, nombre, apellido, correo);
    }

    public List<Usuario> obtenerPorEquipo (Integer id_equipo){
        return usuarioRepository.findUsuariosPorEquipo(id_equipo);
    }

    public void borrarUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }
    public boolean existeUsuario(Integer id){return usuarioRepository.existsById(id);}
}
