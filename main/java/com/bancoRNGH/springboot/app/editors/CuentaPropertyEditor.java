package com.bancoRNGH.springboot.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bancoRNGH.springboot.app.models.dao.ICuentaDao;
import com.bancoRNGH.springboot.app.services.ICuentaService;

@Component
public class CuentaPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private ICuentaService cuentaService;
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	@Override
	public void setAsText(String idStr) throws IllegalArgumentException {
		try {
			Long id= Long.parseLong(idStr);
			this.setValue(cuentaService.getById(id, cuentaDao.FindAll()));
		}catch(Exception e) {
			System.out.println("Hubo un error al asignar el objeto cuenta a la tarjeta");
		}
	}

	
	
}
