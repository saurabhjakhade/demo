package com.example.util;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;  

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.exception.ToDoException;
import com.example.model.Response;
import com.example.model.ToDo;
import com.example.repository.ToDoRepository;
import com.example.service.ToDoServiceImpl;

public class ModelTester {

	
	@Mock
	ToDoRepository repos;
	
	@Autowired
	@InjectMocks
	ToDoServiceImpl service;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		BDDMockito.given(repos.findOne(1L)).willReturn(new ToDo(1,"we",false));
		//this wont work please see the link https://stackoverflow.com/questions/3762047/throw-checked-exceptions-from-mocks-with-mockito
		//in simple words, findOne method does not trow todoException, so u have to throw runtimeException
		//BDDMockito.given(repos.findOne(2L)).willThrow(new ToDoException("Problem in getting TODO"));
		//following is one more way we can throw Exception
		BDDMockito.given(repos.findOne(2L)).willAnswer(answer-> {throw new ToDoException("Problem in getting TODO");});
	}
	
	@Test
	public void testResponse(){
		Response res=new Response(0,"test");
		assertEquals(0, res.getStatus());
		assertEquals("test",res.getMessage());
	}
	
	@Test(expected=NullPointerException.class)
	public void testException(){
		Response res=null;
				res.getMessage();
				
	}
	
	@Test
	public void testToDoService(){
		
	//	Mockito.when(repos.findOne(1L)).thenReturn(new ToDo(1,"test",false));
		ToDo temp=service.getToDoById(1L);            
		assertFalse(temp.isCompleted());
		Mockito.verify(repos,Mockito.atLeastOnce()).findOne(Mockito.anyLong());
		//use this in case you 
		Throwable t=catchThrowable((()->service.getToDoById(2L)));
		
		assertThatThrownBy(()->service.getToDoById(2L)).isExactlyInstanceOf(ToDoException.class);
		
	}
	
}
