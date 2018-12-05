package br.ucsal.busucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.busucsal.model.Roteiro;

public class RoteiroDAO {

	private Connection connection;

	public RoteiroDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Roteiro roteiro) {
		String sql = "insert into roteiros (titulo,  descricao) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, roteiro.getTitulo());
			stmt.setString(2, roteiro.getDescricao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Roteiro> getLista() {
		try {
			List<Roteiro> roteiros = new ArrayList<>();
			String sql = "select id,titulo,descricao from roteiros";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Roteiro roteiro = new Roteiro();
				roteiro.setId(rs.getLong("id"));
				roteiro.setTitulo(rs.getString("titulo"));
				roteiro.setDescricao(rs.getString("descricao"));
				roteiros.add(roteiro);
			}
			rs.close();
			stmt.close();
			return roteiros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Roteiro obter(Long id) {
		Roteiro roteiro = null;
		String sql = "select (id,titulo,descricao) where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				roteiro = new Roteiro();
				roteiro.setId(rs.getLong("id"));
				roteiro.setTitulo(rs.getString("titulo"));
				roteiro.setDescricao(rs.getString("descricao"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return roteiro;

	}

	public void altera(Roteiro roteiro) {
		String sql = "update roteiros set titulo=? descricao=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, roteiro.getTitulo());
			stmt.setString(2, roteiro.getDescricao());
			stmt.setLong(5, roteiro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Roteiro roteiro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from roteiros where id=?");
			stmt.setLong(1, roteiro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
