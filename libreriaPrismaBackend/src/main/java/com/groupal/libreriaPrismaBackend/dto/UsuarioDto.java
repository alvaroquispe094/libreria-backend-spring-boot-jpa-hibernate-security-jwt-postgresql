package com.groupal.libreriaPrismaBackend.dto;

import com.groupal.libreriaPrismaBackend.entity.Rol;

public class UsuarioDto {
	
	    private Integer id;
	    private String nombre;
	    private String apellido;
	    private String usuario;
	    private String email;
	    private String password;
	    private String direccion;
	    private String fechaNacimiento;
	    private String documento;
	    private String rol_nombre;
	    private Rol rol;
	    private Boolean activo;
	  

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(String fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}

		public String getDocumento() {
			return documento;
		}

		public void setDocumento(String documento) {
			this.documento = documento;
		}

		public Boolean getActivo() {
			return activo;
		}

		public void setActivo(Boolean activo) {
			this.activo = activo;
		}

		public Rol getRol() {
			return rol;
		}

		public void setRol(Rol rol) {
			this.rol = rol;
		}

		public String getRol_nombre() {
			return rol_nombre;
		}

		public void setRol_nombre(String rol_nombre) {
			this.rol_nombre = rol_nombre;
		}

}
