package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.ClienteVO;

public class ClienteDAO<VO extends ClienteVO> extends BaseDAO<VO>{
	
		public void inserir(VO vo) {
		String sql = "INSERT INTO Cliente(pessoa_nome,pessoa_cpf,usuario_login,usuario_senha,usuario_tipoUsuario) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getCpf());
			ptst.setString(3,vo.getLogin());
			ptst.setString(4,vo.getSenha());
			ptst.setInt(5,vo.getTipoUsuario());
			
			int affectedRows = ptst.executeUpdate();			
			
			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				vo.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhum Id foi retornado.");
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
		public void removerPorCpf(VO vo) {
			String sql = "DELETE FROM Cliente WHERE pessoa_cpf = '"+vo.getCpf()+"'";
			Statement ptst;
			try {
				ptst = conn.createStatement();;
				ptst.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}

		}
		
		public void removerPorNome(VO vo) {
			String sql = "DELETE * FROM Cliente WHERE pessoa_nome = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getNome());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		public void remover(VO vo) {
			String sql = "DELETE * FROM Cliente WHERE Cliente_id = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setLong(1, vo.getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		public void removerTudo() {
			String sql = "DELETE * FROM Cliente";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		public ResultSet buscarTudo() {
			String sql = "SELECT * FROM Cliente";
			Statement st;
			ResultSet rs = null;
			try {
				st = getConnection().createStatement();
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return rs;
		}
		
		public ResultSet buscarPorId(VO vo) {
			String sql = "SELECT * FROM Cliente WHERE Cliente_id = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setLong(1,vo.getId());
				rs = ptst.executeQuery(sql);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return rs;
		}
		
		public ResultSet buscarPorNome(VO vo) {
			String sql = "SELECT * FROM Cliente WHERE pessoa_nome = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1,vo.getNome());
				rs = ptst.executeQuery(sql);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return rs;
		}
		
		public ResultSet buscarPorCpf(VO vo) {
			String sql = "SELECT * FROM Cliente WHERE pessoa_cpf = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1,vo.getCpf());
				rs = ptst.executeQuery(sql);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return rs;
		}
										
		public void editar(VO vo) throws SQLException {
            conn = getConnection();
            String sql = "UPDATE Cliente SET pessoa_nome = '" + vo.getNome() +  "' WHERE pessoa_cpf = '" + vo.getCpf()+"'";

            try {
                Statement ptst = conn.createStatement();
         
                ptst.executeUpdate(sql);
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
		
		public void editarCpf(VO vo) {
			String sql = "UPDATE Cliente SET pessoa_cpf = ? where Cliente_id = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getCpf());
				ptst.setLong(2, vo.getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
