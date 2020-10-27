package com.lesiw.core.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity 
public class Usuario implements Serializable{

	
	private static final long serialVersionUID = 1671417246199538663L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;

	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String email;
	@Column
	private String usuario;
	@Column
	private String psw;

	@Transient
	private String confirmPsw;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_roles",
			joinColumns=@JoinColumn(name="usuario_id"),
			inverseJoinColumns=@JoinColumn(name="rol_id"))
	private Set<Rol> roles;

	public Usuario() {
		super();
	}

	public Usuario(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String firstName) {
		this.nombre = firstName;
	}

	public String getApellido() {
		return usuario;
	}

	public void setApellido(String lastName) {
		this.apellido = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String username) {
		this.usuario = username;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String password) {
		this.psw = password;
	}

	public String getConfirmPsw() {
		return confirmPsw;
	}

	public void setConfirmPsw(String confirmPassword) {
		this.confirmPsw = confirmPassword;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + nombre + ", lastName=" + apellido + ", email=" + email
				+ ", username=" + usuario + ", password=" + psw + ", confirmPassword=" + confirmPsw
				+ ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmPsw == null) ? 0 : confirmPsw.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((psw == null) ? 0 : psw.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (confirmPsw == null) {
			if (other.confirmPsw != null)
				return false;
		} else if (!confirmPsw.equals(other.confirmPsw))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (psw == null) {
			if (other.psw != null)
				return false;
		} else if (!psw.equals(other.psw))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
