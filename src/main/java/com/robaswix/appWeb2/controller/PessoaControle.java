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

import com.robaswix.appWeb2.cadastros.Pessoa;
import com.robaswix.appWeb2.cadastros.PessoaRepositorio;
import com.robaswix.appWeb2.cadastros.Veiculo;



@Controller
public class PessoaControle {
	
	private PessoaRepositorio pessoaRepo;
	
	public PessoaControle(PessoaRepositorio pessoaRepo) {
		this.pessoaRepo = pessoaRepo;
		
	}
	
	@GetMapping("/cadastros/pessoas")
	public String pessoas(Model model) {
		model.addAttribute("listaPessoas", pessoaRepo.findAll());
		return "cadastros/pessoas/index";
	}
	

	@GetMapping("/cadastros/pessoas/nova")
	public String novaPessoa(Model model) {
		model.addAttribute("pessoa", new Pessoa(""));
		return "cadastros/pessoas/form";
	}

	
	@GetMapping("/cadastros/pessoas/{id}")
	public String alterarPessoa(@PathVariable("id") long id, Model model) {
		Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
		if (!pessoaOpt.isPresent()) {
			throw new IllegalArgumentException("Pessoa Invalida.");
		}
		
		model.addAttribute("pessoa", pessoaOpt.get());
		
		return "cadastros/pessoas/form";
	}

	@PostMapping("/cadastros/pessoas/salvar")
	public String salvarPessoa(@Valid @ModelAttribute("pessoa") Pessoa pessoa, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "cadastros/pessoas/form";
		}

		
		pessoaRepo.save(pessoa);
		return "redirect:/cadastros/pessoas";
	}
	
	
	@GetMapping("/cadastros/pessoas/excluir/{id}")
	public String excluirPessoa(@PathVariable("id") long id, Model model) {
		Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
		if (!pessoaOpt.isPresent()) {
			throw new IllegalArgumentException("Pessoa Invalida.");
		}
		
		pessoaRepo.delete(pessoaOpt.get());
		
		return "redirect:/cadastros/pessoas";
	}


}

