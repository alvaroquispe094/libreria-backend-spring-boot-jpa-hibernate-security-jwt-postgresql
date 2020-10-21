package com.groupal.libreriaPrismaBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "operacionIdSeq", sequenceName = "operacion_id_seq", allocationSize=1)
@Table(name="operacion")
public class Operacion {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "operacionIdSeq")
    private Long id;

 

    private String title;
    
	private String icon;
	
	private String link;
	
	private Boolean home;
	
	private Boolean group;
	
	@Column(name = "es_padre")   
	private Boolean esPadre;
    
	private Boolean activo;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Boolean getHome() {
		return home;
	}

	public void setHome(Boolean home) {
		this.home = home;
	}

	public Boolean getGroup() {
		return group;
	}

	public void setGroup(Boolean group) {
		this.group = group;
	}

	public Boolean getEsPadre() {
		return esPadre;
	}

	public void setEsPadre(Boolean esPadre) {
		this.esPadre = esPadre;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
