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

import com.bancoRNGH.springboot.app.models.dao.IBancoDao;
import com.bancoRNGH.springboot.app.models.entity.Banco;

public class BancoController {
	@Autowired
	private IBancoDao bancoDao;
	
	@RequestMapping(value="/bancos-lista", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de bancos");
		model.addAttribute("bancos", bancoDao.FindAll());
		return "bancos-lista";
	}
	
	@RequestMapping(value="/form-banco")
	public String crear(Map<String, Object> model) {
		
		Banco banco = new Banco();
		
		model.put("banco", banco);
		
		model.put("titulo", "Nuevo Banco");
		model.put("subtitulo", "Llenar los datos de el banco");
		
		return "form-banco";
		
	}
	
	@RequestMapping(value = "/form-banco", method = RequestMethod.POST)
	public String guardar(@Valid Banco banco, BindingResult result, Model model, SessionStatus status,
			RedirectAttributes flash) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Llene correctamente los campos");
			model.addAttribute("result", result.hasErrors());
			model.addAttribute("mensaje", "Error al enviar los datos, por favor escriba correctamente los campos");
			return "form-banco";
		} else {
			model.addAttribute("result", false);
		}
		
		model.addAttribute("titulo", "Formulario de banco");
		model.addAttribute("mensaje", "Se envio la informacion correctamente");
		try {
			bancoDao.save(banco);
		} catch (Exception e) {
			e.printStackTrace();
			flash.addFlashAttribute("mensaje", e.getMessage());
		}
		status.setComplete();

		return "redirect:form-banco";
}

}