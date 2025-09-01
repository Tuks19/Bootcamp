package org.miempresa.vacas.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.miempresa.vacas.models.*;
import org.miempresa.vacas.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/equipo")
@RequiredArgsConstructor
public class EquipoController {

    private final UsuarioServices usuarioServices;
    private final EquipoService equipoService;

    @GetMapping("/consultar_usuarios")
   public String mostrarFormularioEquipo(Model model){
        model.addAttribute("equipos",equipoService.listarTodosEquipos());
        return "/ConsultasEquipo/consulta_usuarios";
   }

    @PostMapping("/consultar-usuarios")
    public String consultarUsuariosPorEquipo(@RequestParam Integer idEquipo,
                                             Model model) {
        List<Usuario> usuarios = usuarioServices.obtenerPorEquipo(idEquipo);
        Equipo equipo = equipoService.obtenerPorId(idEquipo);

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("equipo", equipo);
        model.addAttribute("equipos", equipoService.listarTodosEquipos());

        return "/ConsultasEquipo/resultado_consulta";
    }
}
