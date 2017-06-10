package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pedidos")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L; 

	@Id 
	@Column(name="IDPEDIDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(value=TemporalType.TIMESTAMP) 
	@Column(name="DATA")
	private Date dataPedido;

	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="IDCLIENTE") 
	private Cliente cliente;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="VALOR")
	private double valor;

	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido; 
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente; 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}