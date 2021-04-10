package com.robaswix.appWeb2.cadastros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long> {

	
	
}
