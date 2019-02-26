package com.staxrt.tutorial.repository;

import java.util.List;

import com.staxrt.tutorial.model.User;

public interface CustomTodoRepository {
	public List<User> findBySearchTerm(User searchTerm);
}
