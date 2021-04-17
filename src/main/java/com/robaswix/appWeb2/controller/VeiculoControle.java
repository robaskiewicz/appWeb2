package com.robaswix.appWeb2.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.robaswix.appWeb2.cadastros.Veiculo;
import com.robaswix.appWeb2.cadastros.VeiculoRepositorio;

@Controller
public class VeiculoControle {

	
	private VeiculoRepositorio veiculorepo;
	
	public VeiculoControle(VeiculoRepositorio veiculorepo) {
		this.veiculorepo = veiculorepo;
		
	}
	
	@GetMapping("/cadastros/veiculos")
	public String pessoas(Model model) {
		model.addAttribute("listaVeiculos", veiculorepo.findAll());
		return "cadastros/veiculos/index";
	}
	

	@GetMapping("/cadastros/veiculos/nova")
	public String novaPessoa(Model model) {
		model.addAttribute("veiculo", new Veiculo(""));
		return "cadastros/veiculos/form";
	}

	
	@GetMapping("/cadastros/veiculos/{id}")
	public String alterarVeiculos(@PathVariable("id") long id, Model model) {
		Optional<Veiculo> veiculoOpt = veiculorepo.findById(id);
		if (!veiculoOpt.isPresent()) {
			throw new IllegalArgumentException("Pessoa Invalida.");
		}
		
		model.addAttribute("veiculo", veiculoOpt.get());
		
		return "cadastros/veiculos/form";
	}

	@PostMapping("/cadastros/veiculos/salvar")
	public String salvarVeiculo(@Valid @ModelAttribute("veiculo") Veiculo veiculo,BindingResult bindingResult, Model model ) {
		if(bindingResult.hasErrors()) {
			return "cadastros/veiculos/form";
		}
		
		veiculorepo.save(veiculo);
		return "redirect:/cadastros/veiculos";
	}
	
	
	@GetMapping("/cadastros/veiculos/excluir/{id}")
	public String excluirVeiculo(@PathVariable("id") long id, Model model) {
		Optional<Veiculo> veiculoOpt = veiculorepo.findById(id);
		if (!veiculoOpt.isPresent()) {
			throw new IllegalArgumentException("Veiculo Invalido.");
		}
		
		veiculorepo.delete(veiculoOpt.get());
		
		return "redirect:/cadastros/veiculos";
	}

	
	
	
	
}
