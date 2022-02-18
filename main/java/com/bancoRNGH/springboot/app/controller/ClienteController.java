package com.bancoRNGH.springboot.app.controller;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bancoRNGH.springboot.app.models.dao.IClienteDao;
import com.bancoRNGH.springboot.app.models.entity.Cliente;

public class ClienteController {
	@Autowired
	private IClienteDao clienteDao;
	
	@RequestMapping(value = "/clientes-lista", method = RequestMethod.GET)
	public String listar(Model model, Map<String, Object> modelCliente) {
		
		Cliente cliente =  new Cliente();
		modelCliente.put("cliente", cliente);
		
		model.addAttribute("titulo", "Lista de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "clientes-lista";
	}
	
	@RequestMapping(value="/form-cliente")
	public String crear(Map<String, Object> model) {
		
		Cliente cliente = new Cliente();
		model.put("titulo", "Nuevo cliente");
		model.put("cliente", cliente);
		model.put("subtitulo", "Llenar los datos correspondientes");
		
		return "form-cliente";
	}
	
	@RequestMapping(value="/form-cliente", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result,
			Model model, SessionStatus status, RedirectAttributes flash) {
		
		//Verifica si hay errores en el formulario
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Llene los campos correctamente");
			model.addAttribute("result", result.hasErrors());
			model.addAttribute("mensaje", 
					"Error al enviar los datos, por favor escriba correctamente los campos");
			return "form-cliente";
		}else {
			model.addAttribute("result", false);
		}
		
		model.addAttribute("titulo", "Formulario de cliente");
		model.addAttribute("mensaje", "Se envio la información correctamente");
		
		try {
			clienteDao.save(cliente);
		}catch(Exception e) {
			e.printStackTrace();
			flash.addFlashAttribute("mensaje", e.getMessage());
		}
		
		status.setComplete();
		
		//return "redirect:clientes-lista";
		return "redirect:form-cliente";
	}
	
	@RequestMapping(value="/buscar-numero-telefono", method = RequestMethod.POST)
	public String cargarClientesByNumeroTelefonoYId(Cliente cliente, RedirectAttributes flash) {
		if(clienteDao.findById(Long.parseLong(cliente.getNumeroTelefono())) != null) {
			flash.addFlashAttribute("clientesFound", clienteDao.findById(Long.parseLong(cliente.getNumeroTelefono())));
			flash.addFlashAttribute("mensajeSuccess", "Se encontró el cliente");
		}
		else if(!clienteDao.findByNumeroTelefono(cliente.getNumeroTelefono()).isEmpty()) {
			flash.addFlashAttribute("clientesFound", clienteDao.findByNumeroTelefono(cliente.getNumeroTelefono()));
			flash.addFlashAttribute("mensajeSuccess", "Se encontraron "+clienteDao.findByNumeroTelefono(cliente.getNumeroTelefono()).size()+" clientes");
		}else {
			flash.addFlashAttribute("mensajeError", "No se encontró ningun registro");
		}
		
		return "redirect:/clientes-lista";
}
}
