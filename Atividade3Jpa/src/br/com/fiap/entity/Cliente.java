package br.com.fiap.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="IDCLIENTE") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="NOME") 
	private String nome;
	

	@Column(name="EMAIL") 
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")
	private Set<Pedido> pedidos = new LinkedHashSet<Pedido>();


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
