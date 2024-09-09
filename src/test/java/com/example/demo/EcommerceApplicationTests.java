package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.AcessoController;
import com.example.demo.model.Acesso;
import com.example.demo.repository.AcessoRepository;
import com.example.demo.service.AcessoService;

@SpringBootTest(classes = EcommerceApplication.class)
public class EcommerceApplicationTests {
	
	
	@Autowired
	private AcessoController acessoController;
	
	@Test
	public void testCadastraAcesso() {
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_ADMIN");
		
		acessoController.salvarAcesso(acesso);
	}

}
