package br.ucsal.busucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.busucsal.model.Horario;
import br.ucsal.busucsal.model.Roteiro;

public class HorarioDAO {

	private Connection connection;

	public HorarioDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Horario horario) {
		String sql = "insert into horarios (HORA_INICIO, DIA_DA_SEMANA, ROTEIRO_ID) values (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, horario.getHoraInicio());
			stmt.setString(2, horario.getDiaDaSemana());
			stmt.setLong(3, horario.getRoteiro().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	

	public Horario get(Long id) {
		Horario horario = null;
		try {
			String sql = "select ID, HORA_INICIO, DIA_DA_SEMANA, ROTEIRO_ID, "
					+ "TITULO, DESCRICAO  "
					+ "from horarios join roteiros ON horarios.ROTEIRO_ID = roteiros.id "
					+ "where id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				horario = new Horario();
				horario.setId(rs.getLong("ID"));
				horario.setHoraInicio(rs.getString("HORA_INICIO"));
				horario.setDiaDaSemana(rs.getString("DIA_DA_SEMANA"));
				Roteiro roteiro = new Roteiro();
				roteiro.setId(rs.getLong("ROTEIRO_ID"));
				roteiro.setTitulo(rs.getString("DIA_DA_SEMANA"));
				roteiro.setTitulo(rs.getString("DESCRICAO"));
				horario.setRoteiro(roteiro);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return horario;
	}

	public List<Horario> getLista() {
		try {
			List<Horario> horarios = new ArrayList<>();
			String sql = "select ID, HORA_INICIO, DIA_DA_SEMANA, ROTEIRO_ID, "
					+ "TITULO, DESCRICAO  "
					+ "from horarios join roteiros ON horarios.ROTEIRO_ID = roteiros.id ";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Horario horario = new Horario();
				horario.setId(rs.getLong("ID"));
				horario.setHoraInicio(rs.getString("HORA_INICIO"));
				horario.setDiaDaSemana(rs.getString("DIA_DA_SEMANA"));
				Roteiro roteiro = new Roteiro();
				roteiro.setId(rs.getLong("ROTEIRO_ID"));
				roteiro.setTitulo(rs.getString("DIA_DA_SEMANA"));
				roteiro.setTitulo(rs.getString("DESCRICAO"));
				horario.setRoteiro(roteiro);
				horarios.add(horario);
			}
			rs.close();
			stmt.close();
			return horarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Horario horario) {
		String sql = "update horarios set hora_inicio=?, DIA_DA_SEMANA=?, ROTEIRO_ID=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, horario.getHoraInicio());
			stmt.setString(2, horario.getDiaDaSemana());
			stmt.setLong(3, horario.getRoteiro().getId());
			stmt.setLong(4, horario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from horarios where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
