package com.bancoRNGH.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import com.bancoRNGH.springboot.app.models.entity.Cliente;

public class ClienteDaoImpl implements IClienteDao {

		@PersistenceContext
		private EntityManager em;

		@SuppressWarnings("unchecked")
		@Transactional
		public List<Cliente> findAll() {
			return em.createQuery("from Cliente").getResultList();
		}

		@Override
		@Transactional
		public Cliente findOne(Long id) {
			return em.find(Cliente.class, id);

		}

		@Override
		@Transactional
		public void save(Cliente cliente) {
			if (cliente.getId_cliente() != null && cliente.getId_cliente() > 0) {
				em.merge(cliente);
			} else {
				em.persist(cliente);
			}
			}
		
			
			@Override
			@Transactional
			public void delete(Long id) {
				em.remove(findOne(id));
		}


			@Transactional(readOnly = true)
			@Override
			public List<Cliente> findByNumeroTelefono(String telefono) {
				
				List<Cliente> listaClientes = this.findAll();
				List<Cliente> result = new ArrayList<Cliente>();
				
				for(Cliente cliente: listaClientes) {
					
					if(cliente.getNumeroTelefono().equals(telefono)) {
						result.add(cliente);
					}
					
				}
				
				return result;
			}

			@Transactional(readOnly = true)
			@Override
			public Cliente findById(Long id) {

				List<Cliente> lista = this.findAll();
				Cliente result = null;
				
				for(Cliente cliente: lista) {
					if(cliente.getId_cliente() == id) {
						result = cliente;
					}
				}
				
				return result;
			}
			
	
}
