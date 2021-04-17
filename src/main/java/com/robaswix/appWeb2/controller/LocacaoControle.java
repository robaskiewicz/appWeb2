package com.robaswix.appWeb2.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.robaswix.appWeb2.cadastros.Locacao;
import com.robaswix.appWeb2.cadastros.LocacaoRepositorio;
import com.robaswix.appWeb2.cadastros.Pessoa;
import com.robaswix.appWeb2.cadastros.PessoaRepositorio;
import com.robaswix.appWeb2.cadastros.VeiculoRepositorio;



@Controller
public class LocacaoControle {
	
	private PessoaRepositorio pessoaRepo;
	private LocacaoRepositorio locacaoRepo;
	private VeiculoRepositorio veiculoRepo;
//	private VeiculoRepositorio veiculoRepo;
	
	public LocacaoControle(PessoaRepositorio pessoaRepo, LocacaoRepositorio locacaoRepo, VeiculoRepositorio veiculoRepo) {
		this.pessoaRepo = pessoaRepo;
		this.locacaoRepo = locacaoRepo;
		this.veiculoRepo = veiculoRepo;
	
	}
	
	@GetMapping("/cadastros/locacoes")
	public String locacaoes(Model model) {
		model.addAttribute("listaLocacoes", locacaoRepo.findAll());
		return "cadastros/locacoes/index";
	}
	

	@GetMapping("/cadastros/locacoes/nova")
	public String novaLocacao(Model model) {
		model.addAttribute("locacao", new Locacao());
		
		model.addAttribute("pessoas", pessoaRepo.findAll());
		model.addAttribute("veiculos", veiculoRepo.findAll());
//		model.addAttribute("veiculos", pessoaRepo.findAll());
		
		return "cadastros/locacoes/form";
	}

	
	@GetMapping("/cadastros/locacoes/{id}")
	public String alterarLocacao(@PathVariable("id") long id, Model model) {
		Optional<Locacao> locacaoOpt = locacaoRepo.findById(id);
		if (!locacaoOpt.isPresent()) {
			throw new IllegalArgumentException("Locacao Invalida.");
		}
		
		model.addAttribute("pessoas", pessoaRepo.findAll());
		model.addAttribute("veiculos", veiculoRepo.findAll());
//		model.addAttribute("veiculos", pessoaRepo.findAll());
		
		model.addAttribute("locacao", locacaoOpt.get());
		
		return "cadastros/locacoes/form";
	}

	@PostMapping("/cadastros/locacoes/salvar")
	public String salvarLocacao(@ModelAttribute("locacao") Locacao locacao, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "cadastros/locacoes/form";
		}
		
		locacaoRepo.save(locacao);
		return "redirect:/cadastros/locacoes";
	}
	
	
	@GetMapping("/cadastros/locacoes/excluir/{id}")
	public String excluirLocacao(@PathVariable("id") long id, Model model) {
		Optional<Locacao> locacaoOpt = locacaoRepo.findById(id);
		if (!locacaoOpt.isPresent()) {
			throw new IllegalArgumentException("Locacao Invalida.");
		}
		
		locacaoRepo.delete(locacaoOpt.get());
		
		return "redirect:/cadastros/locacoes";
	}


}

