package br.com.gerenciador.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.gerenciador.model.Status;
import br.com.gerenciador.model.Usuario;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Inject
	private Usuario usuario;
	
	public void salvar() {
		try {
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
			usuario = new Usuario();
		} catch (Exception e) {
			throw new RuntimeException("Erro salvando usuario", e);
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Status> getStatusList() {
		return Arrays.asList(Status.values());
	}
	
}

