package com.cine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cine.model.Usuario;
import com.cine.repository.IRolRepository;
import com.cine.repository.IUsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioRepository usu;
	
	@Autowired
	private IRolRepository rol;
	
	@GetMapping("/listar")
	public String listadoUsuario(Model model) {
		model.addAttribute("lstUsuarios", usu.findAll());
		return "listado";
	}
	
	@GetMapping("/")
	public String cargarUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("lstRoles", rol.findAll());
		return "crudusuarios";
	}
	
	@PostMapping("/grabar")
	public String grabarPag(@ModelAttribute Usuario usuario) {
		usu.save(usuario);
		return "redirect:/listar";
	}
	
}
