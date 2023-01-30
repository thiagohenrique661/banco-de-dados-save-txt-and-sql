import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class CRUD {

	public void create(Detritos detritos) {
		Connection con = ConexaoBD.getConnection();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(
					"INSERT INTO DetritoEspacial(cod,nome,classe,estado,lancamento,reentrada,velocidade) values (?,?,?,?,?,?,?);");
			st.setInt(1, detritos.getCod());
			st.setString(2, detritos.getNome());
			st.setString(3, detritos.getClasse());
			st.setString(4, detritos.getEstado());
			st.setInt(5, detritos.getLancamento());
			st.setInt(6, detritos.getReentrada());
			st.setString(7, detritos.getVelocidade());
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERRO NA INSERÇÃO!" + e);

		} finally {
			ConexaoBD.closeConnection(con, st);
		}

	}

	public void update(Detritos detritos) {
		Connection con = ConexaoBD.getConnection();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(
					"UPDATE DetritoEspacial SET nome=?,clase=?,estado=?,lancamento=?,reentrada=?,velocidade=? WHERE cod = ?");
			st.setInt(7, detritos.getCod());
			st.setString(1, detritos.getNome());
			st.setString(2, detritos.getClasse());
			st.setString(3, detritos.getEstado());
			st.setInt(4, detritos.getLancamento());
			st.setInt(5, detritos.getReentrada());
			st.setString(6, detritos.getVelocidade());
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, " ALTERADO!");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConexaoBD.closeConnection(con, st);
		}

	}

	public boolean delete(Detritos detritos) {
		Connection con = ConexaoBD.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("delete from DetritoEspacial where cod = ?");
			stmt.setInt(1, detritos.getCod());
			if (stmt.executeUpdate() == 1) {
				JOptionPane.showMessageDialog(null, "DELETADO!");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "ERRO NO DELETE!");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ConexaoBD.closeConnection(con, stmt);
		}
	}

	public ArrayList<Detritos> read() {

		Connection con = ConexaoBD.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Detritos> dados = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM detritoEspacial");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Detritos dado = new Detritos();

				dado.setCod(rs.getInt("cod"));
				dado.setNome(rs.getString("nome"));
				dado.setClasse(rs.getString("classe"));
				dado.setEstado(rs.getString("estado"));
				dado.setLancamento(rs.getInt("lancamento"));
				dado.setReentrada(rs.getInt("reentrada"));
				dado.setVelocidade(rs.getString("velocidade"));
				dados.add(dado);
			}

		} catch (SQLException ex) {
			Logger.getLogger(Detritos.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConexaoBD.closeConnection(con, stmt, rs);
		}

		return dados;
	}

	public ArrayList<Detritos> readForDesc(String cod) {

		Connection con = ConexaoBD.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Detritos> dados = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM DetritoEspacial WHERE cod LIKE ?");
			stmt.setString(1, "%" + cod + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Detritos dado = new Detritos();

				dado.setCod(rs.getInt("cod"));
				dado.setNome(rs.getString("nome"));
				dado.setClasse(rs.getString("classe"));
				dado.setEstado(rs.getString("estado"));
				dado.setLancamento(rs.getInt("lancamento"));
				dado.setReentrada(rs.getInt("reentrada"));
				dado.setVelocidade(rs.getString("velocidade"));
				dados.add(dado);
			}

		} catch (SQLException ex) {
			Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConexaoBD.closeConnection(con, stmt, rs);
		}

		return dados;

	}

	public ArrayList<Detritos> txt() throws IOException {

		ArrayList<Detritos> dados = new ArrayList<>();

		try {
			FileInputStream arquivo = new FileInputStream("c:APS/ARQUIVOS TXT/APSTXT.TXT");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);

			String linha1;
			do {
				linha1 = br.readLine();
				if (linha1 != null) {

				}
			} while (linha1 != null);

		} catch (IOException ex) {
			Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
		} finally {

		}

		return dados;
	}

}
