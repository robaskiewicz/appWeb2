package com.robaswix.appWeb2.controller;

import org.springframework.stereotype.Controller;

import com.robaswix.appWeb2.cadastros.VeiculoRepositorio;

@Controller
public class VeiculoControle {

	
	private VeiculoRepositorio veiculorepo;
	
	public VeiculoControle(VeiculoRepositorio veiculorepo) {
		this.veiculorepo = veiculorepo;
		
	}
	
	
	
	
}
