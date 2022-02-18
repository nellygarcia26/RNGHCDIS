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

import com.bancoRNGH.springboot.app.models.dao.IEmpleadoDao;
import com.bancoRNGH.springboot.app.models.entity.Empleado;

public class EmpleadoController {

	
	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@RequestMapping(value="/empleados-lista", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de empleados");
		model.addAttribute("empleados", empleadoDao.findAll());
		return "empleados-lista";
	}
	
	
	@RequestMapping(value="/form-empleado")
	public String crear(Map<String, Object> model) {
		
		Empleado empleado = new Empleado();
		
		model.put("empleado", empleado);
		
		model.put("titulo", "Nuevo Empleado");
		model.put("subtitulo", "Llenar los datos de el banco");
		
		return "form-empleado";
		
	}
	
	@RequestMapping(value = "/form-empleado", method = RequestMethod.POST)
	public String guardar(@Valid Empleado empleado, BindingResult result, Model model, SessionStatus status,
			RedirectAttributes flash) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Llene correctamente los campos");
			model.addAttribute("result", result.hasErrors());
			model.addAttribute("mensaje", "Error al enviar los datos, por favor escriba correctamente los campos");
			return "form-empleado";
		} else {
			model.addAttribute("result", false);
		}
		
		model.addAttribute("titulo", "Formulario de empleado");
		model.addAttribute("mensaje", "Se envio la informacion correctamente");
		try {
			empleadoDao.save(empleado);
		} catch (Exception e) {
			e.printStackTrace();
			flash.addFlashAttribute("mensaje", e.getMessage());
		}
		status.setComplete();

		return "redirect:form-empleado";
	}

}
