package org.miempresa.vacas.controllers;

import lombok.RequiredArgsConstructor;
import org.miempresa.vacas.models.*;
import org.miempresa.vacas.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServices usuarioServices;
    private final RolService rolService;
    private final CargoService cargoService;
    private final EquipoService equipoService;

    @GetMapping("/opciones")
    public String opciones() {
        return "INDEX";
    }

    @GetMapping("/all")
    public String getAllUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioServices.listarTodosUsuarios());
        return "CRUD/lista_usuarios";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.listarTodosRoles());
        model.addAttribute("cargos", cargoService.listarTodosCargos());
        model.addAttribute("equipos", equipoService.listarTodosEquipos());

        return "CRUD/crear_usuario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario,
                                 @RequestParam(required = false) Integer idRol,
                                 @RequestParam(required = false) Integer idCargo,
                                 @RequestParam(required = false) Integer idEquipo,
                                 RedirectAttributes redirectAttributes) {

        if (idRol != null) {
            Rol rol = new Rol();
            rol.setId_rol(idRol);
            usuario.setRol(rol);
        }

        if (idCargo != null) {
            Cargo cargo = new Cargo();
            cargo.setId_cargo(idCargo);
            usuario.setCargo(cargo);
        }

        if (idEquipo != null) {
            Equipo equipo = new Equipo();
            equipo.setId_equipo(idEquipo);
            usuario.setEquipo(equipo);
        }

        if (usuario.getDiasVacaciones() == null) {
            usuario.setDiasVacaciones(0);
        }

        if (usuario.getDiasVacacionesRestante() == null) {
            usuario.setDiasVacacionesRestante(0);
        }

        if (usuario.getEstado() == null) {
            usuario.setEstado(true);
        }

        if (usuario.getFechaIngreso() == null) {
            usuario.setFechaIngreso(LocalDate.now());
        }

        usuarioServices.guardarUsuario(usuario);
        redirectAttributes.addFlashAttribute("mensaje", "Usuario creado con éxito!");
        return "redirect:/usuario/all";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        if (usuarioServices.existeUsuario(id)) {
            Usuario usuario = usuarioServices.obtenerPorId(id);
            model.addAttribute("usuario", usuario);

            return "CRUD/editar_usuario";
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "CRUD/error";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarUsuario(@PathVariable Integer id,
                                    @ModelAttribute Usuario usuario,
                                    RedirectAttributes redirectAttributes) {

        usuarioServices.actualizarUsuario(id, usuario.getNombre(), usuario.getApellido(), usuario.getCorreo());
        redirectAttributes.addFlashAttribute("mensaje", "Usuario actualizado con éxito!");
        return "redirect:/usuario/all";
    }

    @GetMapping("/eliminar/{id}")
    public String mostrarConfirmacionEliminar(@PathVariable Integer id, Model model) {
        if (usuarioServices.existeUsuario(id)) {
            Usuario usuario = usuarioServices.obtenerPorId(id);
            model.addAttribute("usuario", usuario);
            return "CRUD/confirmar_eliminar";
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "CRUD/error";
        }
    }

    @PostMapping("/eliminar/{id}")
    public String borrarUsuario(@PathVariable Integer id,
                                RedirectAttributes redirectAttributes) {
        usuarioServices.borrarUsuario(id);
        redirectAttributes.addFlashAttribute("mensaje", "Usuario eliminado con éxito!");
        return "redirect:/usuario/all";
    }
}