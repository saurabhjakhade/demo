package com.example.repository;

import java.util.List;

import com.example.exception.RecordDuplicateException;
import com.example.exception.RecordNotFoundException;

public interface ICommonDao<T> {

	public T findById( long id) throws RecordNotFoundException;
	public List<T> findAll(String query);
	public T delete( long id) throws RecordNotFoundException;
	public List<T> executeQuery(String query);
	public void executeUpdate(String query);
	public T save(T obj) throws RecordDuplicateException;
	public T update(T obj) throws RecordNotFoundException;
	public void batchUpdate(List<T> obj) throws RecordNotFoundException;
}
