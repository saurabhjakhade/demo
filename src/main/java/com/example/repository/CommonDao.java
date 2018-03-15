package com.example.repository;

import java.util.List;

import com.example.exception.RecordDuplicateException;
import com.example.exception.RecordNotFoundException;

public class CommonDao<T> implements ICommonDao<T> {
	
	//sessionFactory
	//session
	//put all following methods in some template class like springhibernatesupportdao, 

	@Override
	public T findById(long id) throws RecordNotFoundException {
		
		return null;
	}

	@Override
	public List<T> findAll(String query) {
		
		return null;
	}

	@Override
	public T delete(long id) throws RecordNotFoundException {
	
		return null;
	}

	@Override
	public List<T> executeQuery(String query) {
	
		return null;
	}

	@Override
	public void executeUpdate(String query) {
		
		
	}

	@Override
	public T save(T obj) throws RecordDuplicateException {
	
		return null;
	}

	@Override
	public T update(T obj) throws RecordNotFoundException {
		
		return null;
	}

	@Override
	public void batchUpdate(List<T> obj) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
