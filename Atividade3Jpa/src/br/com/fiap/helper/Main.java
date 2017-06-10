package br.com.fiap.helper;

import java.util.Date;
import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public class Main {

	public static void main(String[] args) {
		inserirCliente();
		listarCliente();
		buscarCliente(1);
		alterarCliente();
		excluirCliente(1);
	}
	
	private static void listarCliente() {
		GenericDao<Cliente> dao = new GenericDao<>(Cliente.class);
		List<Cliente> Cliente = dao.listar();
		for (Cliente cliente : Cliente) {
			System.out.println(cliente.getNome() + ": " + cliente.getEmail());
		}
	}

	private static void buscarCliente(Integer idCliente) {
		GenericDao<Cliente> dao = new GenericDao<>(Cliente.class);
		Cliente f = dao.buscar(idCliente);
		System.out.println(f.getNome() + ": " + f.getEmail());
	}
	
	private static void inserirCliente() {

		Cliente cliente = new Cliente();
		cliente.setNome("Cliente Fulano");
		cliente.setEmail("fulano@email.com");
		

		Pedido pedido = new Pedido();
		pedido.setDataPedido(new Date());
		pedido.setDescricao("descricao do pedido 1");
		pedido.setValor(1000);
		pedido.setCliente(cliente);

		cliente.getPedidos().add(pedido);

		Pedido pedido2 = new Pedido();
		pedido2.setDataPedido(new Date());
		pedido2.setDescricao("descricao do pedido 2");
		pedido2.setValor(1500);
		pedido2.setCliente(cliente);

		cliente.getPedidos().add(pedido2);

		try {
			GenericDao<Cliente> dao = new GenericDao<>(Cliente.class);
			dao.adicionar(cliente);
			System.out.println("Cliente inserido com sucesso");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void excluirCliente(int id) {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		Pedido pedidos = new Pedido();
		pedidos.setId(1);

		try {
			GenericDao<Cliente> dao = new GenericDao<>(Cliente.class);
			dao.remover(cliente);
			System.err.println("Cliente Excluido com sucesso!");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	private static void alterarCliente() {
		Cliente clienteAlter = new Cliente();
		clienteAlter.setId(1);
		clienteAlter.setEmail("fulano2017@email.com");
		clienteAlter.setNome("Fulado da Silva");
		Pedido pedidos = new Pedido();
		
		pedidos.setCliente(clienteAlter);
		pedidos.setDataPedido(new Date());
		pedidos.setDescricao("descricao do pedido 1 alterado");
		pedidos.setId(1);
		pedidos.setValor(1099);

		try {
			GenericDao<Cliente> dao = new GenericDao<>(Cliente.class);
			dao.atualizar(clienteAlter);
			System.out.println("Alterado com sucesso");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
