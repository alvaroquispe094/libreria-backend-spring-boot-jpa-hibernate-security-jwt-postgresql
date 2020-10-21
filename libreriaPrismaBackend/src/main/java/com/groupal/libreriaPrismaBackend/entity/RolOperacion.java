package com.groupal.libreriaPrismaBackend.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "rolOperacionIdSeq", sequenceName = "rol_operacion_id_seq", allocationSize=1)
@Table(name="rol_operacion")
public class RolOperacion {

	 	@Id
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "rolOperacionIdSeq")
	    private Long id;
	 	
	 	@ManyToOne (cascade = CascadeType.ALL)
		@JoinColumn( name="rol_id")
	 	private Rol rol;
	 	
	 	@ManyToOne (cascade = CascadeType.ALL)
		@JoinColumn( name="operacion_id")
	    private Operacion operacion; 
	   
	 	private Integer orden;
	 	
	 	@Transient
	 	private List<RolOperacion> childrens;	
	 	
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Rol getRol() {
			return rol;
		}

		public void setRol(Rol rol) {
			this.rol = rol;
		}

		public Operacion getOperacion() {
			return operacion;
		}

		public void setOperacion(Operacion operacion) {
			this.operacion = operacion;
		}

		public Integer getOrden() {
			return orden;
		}

		public void setOrden(Integer orden) {
			this.orden = orden;
		}

		public Boolean getActivo() {
			return activo;
		}

		public void setActivo(Boolean activo) {
			this.activo = activo;
		}

		private Boolean activo;
	
		public List<RolOperacion> getChildrens() {
			return childrens;
		}

		public void setChildrens(List<RolOperacion> childrens) {
			this.childrens = childrens;
		}

}
