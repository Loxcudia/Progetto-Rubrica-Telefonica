package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {
	T get(String sql) throws SQLException;
	ArrayList<T> getAll(String sql) throws SQLException;
	void update(T obj) throws SQLException;
	void delete(T obj) throws SQLException;
	void insert(T obj) throws SQLException;
}
