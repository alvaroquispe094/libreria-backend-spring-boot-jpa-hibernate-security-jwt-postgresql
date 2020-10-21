package com.groupal.libreriaPrismaBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado {
	
	public static final Integer INGRESADO = new Integer(1);
	public static final Integer CONFIRMADO = new Integer(2);
	public static final Integer PAGADO = new Integer(3);
	public static final Integer CANCELADO = new Integer(4);
	public static final Integer ENVIADO = new Integer(5);
	public static final Integer PRESTADO = new Integer(5);
	public static final Integer DEVUELTO = new Integer(5);
	public static final Integer MOROSO = new Integer(5);
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "estadoIdSeq")
	private Integer id;
	private String nombre;
	private Boolean activo;
	
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
