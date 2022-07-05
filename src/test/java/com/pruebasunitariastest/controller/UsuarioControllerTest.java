package com.pruebasunitariastest.controller;

import com.pruebasunitarias.entity.Usuario;
import com.pruebasunitarias.repository.UsuarioRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioControllerTest {

	@Autowired
	Usuario usuario;
	
	@Test
	void ingresarUsuarioAlSistema() {
		 usuario = new Usuario(1, "Juan", "Perez");
		 System.out.print("entrando");
	}
	
	@Test
	public void whenNotUseMockAnnotation_thenCorrect() {
	    List mockList = Mockito.mock(ArrayList.class);
	    
	    mockList.add("one");
	    Mockito.verify(mockList).add("one");
	    assertEquals(0, mockList.size());

	    Mockito.when(mockList.size()).thenReturn(100);
	    assertEquals(100, mockList.size());
	}
}
