package com.groupal.libreriaPrismaBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "rolIdSeq", sequenceName = "rol_id_seq", allocationSize=1)
@Table(name="rol")
public class Rol {
	
	public static final Integer ROLE_ADMIN = new Integer(1);
	public static final Integer ROLE_RECEPTIONIST = new Integer(2);
	public static final Integer ROLE_USER = new Integer(3);

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "rolIdSeq")
    private Integer id;

	@Column(name = "rol_nombre")    
	private String rolNombre;
    
	private Boolean activo;

    public Rol() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

		public String getRol_nombre() {
			return rolNombre;
		}

		public void setRol_nombre(String rol_nombre) {
			this.rolNombre = rol_nombre;
		}
}
