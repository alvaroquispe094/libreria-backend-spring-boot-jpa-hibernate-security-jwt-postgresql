package com.groupal.libreriaPrismaBackend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "usuarioRolIdSeq", sequenceName = "usuario_rol_id_seq", allocationSize=1)
@Table(name="usuario_rol")
public class UsuarioRol {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,  generator = "usuarioRolIdSeq")
    private Integer id;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn( name="rol_id")
 	private Rol rol;
 	
 	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn( name="usuario_id")
 	private Usuario usuario;
 	
 	private Boolean activo;
	 	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	 	
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
