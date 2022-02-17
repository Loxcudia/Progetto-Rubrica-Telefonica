package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.DBConnection;
import Model.NumeroTelefonoFisso;

public class NumeroTelefonoFissoDAO implements DAO<NumeroTelefonoFisso> {
	private DBConnection dbc = DBConnection.getInstance();
	@Override
	public NumeroTelefonoFisso get(String sql) throws SQLException {
		ResultSet rs = dbc.executeQuery(sql);
		if(rs.next())
		{
			return extract(rs);
		}
		else
		{
			return null;
		}
	}

	@Override
	public ArrayList<NumeroTelefonoFisso> getAll(String sql) throws SQLException {
		ResultSet rs = dbc.executeQuery(sql);
		ArrayList<NumeroTelefonoFisso> list = new ArrayList<>();
		while(rs.next())
		{
			list.add(extract(rs));
		}
		return list;
	}
	private NumeroTelefonoFisso extract(ResultSet rs) throws SQLException
	{
		return new NumeroTelefonoFisso(rs.getString("numero"));
	}


	@Override
	public void update(NumeroTelefonoFisso obj) throws SQLException {
		String sql = "UPDATE NumeroTelefono SET numero = " + obj.getNumero() + " WHERE numero = " + obj.getNumero();
		dbc.executeQuery(sql);
	}

	@Override
	public void delete(NumeroTelefonoFisso obj) throws SQLException {
		String sql = "DELETE FROM NumeroTelefono WHERE numero = " + obj.getNumero();
		dbc.execute(sql);
	}

	@Override
	public void insert(NumeroTelefonoFisso obj) throws SQLException {
		String sql = "INSERT INTO NumeroTelefono(numero) VALUES(" + obj.getNumero() + ")";
		dbc.execute(sql);
	}

}
