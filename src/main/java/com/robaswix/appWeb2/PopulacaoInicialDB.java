package com.robaswix.appWeb2;

import java.time.LocalDate;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.robaswix.appWeb2.cadastros.Locacao;
import com.robaswix.appWeb2.cadastros.LocacaoRepositorio;
import com.robaswix.appWeb2.cadastros.Pessoa;
import com.robaswix.appWeb2.cadastros.PessoaRepositorio;

//@Transactional
@Component
public class PopulacaoInicialDB implements CommandLineRunner{
	
	@Autowired
	private PessoaRepositorio pessoaRepo;
	@Autowired
	private LocacaoRepositorio locacaoRepo;
//	@Autowired
//	private ProdutoRepositorio produtoRepo;
//	@Autowired
//	private PedidoRepositorio pedidoRepo;
//	@Autowired
//	private PedidoItemRepositorio pedidoItemRepo;
//	
	
	@Override
	public void run(String... args) throws Exception{
		
		//Clientes
		Pessoa c1 = new Pessoa("Crystian");
		c1.setTelefone("9999-9999");
		c1.setEmail("crystian@gmail.com");
		
		Pessoa c2 = new Pessoa("Gisele");
		c2.setTelefone("9999-8888");
		c2.setEmail("gisele@gmail.com");

		Pessoa c3 = new Pessoa("Maria Julia");
		c3.setTelefone("9999-7777");
		c3.setEmail("maria@gmail.com");
		
		Pessoa c4= new Pessoa("Rafael");
		c4.setTelefone("9999-6666");
		c4.setEmail("rafael@gmail.com");
		
		pessoaRepo.save(c1);
		pessoaRepo.save(c2);
		pessoaRepo.save(c3);
		pessoaRepo.save(c4);
		
		Locacao locacao = new Locacao();
		locacao.setDataRetirada(new Date());
		locacao.setDataDevolucao(new Date());
		locacao.setPessoa(c1);
		
		locacaoRepo.save(locacao);


	
	}

}
