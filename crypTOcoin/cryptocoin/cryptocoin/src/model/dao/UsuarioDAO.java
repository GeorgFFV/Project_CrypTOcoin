package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.UsuarioVO;

public class UsuarioDAO<VO extends UsuarioVO> extends BaseDAO<VO>{
	
	public void inserir(VO vo) {
		String sql = "INSERT INTO usuario(pessoa_nome,pessoa_cpf,usuario_login,usuario_senha,usuario_tipousuario, usuario_id) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getCpf());
			ptst.setString(3,vo.getLogin());
			ptst.setString(4,vo.getSenha());
			ptst.setInt(5,vo.getTipoUsuario());
			ptst.setLong(6,vo.getId());

			int affectedRows = ptst.executeUpdate();			
			
			if (affectedRows == 0) {
				throw new SQLException("A insercao falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				vo.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A insercao falhou. Nenhum Id foi retornado.");
			}	
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void remover(VO vo) {
		String sql = "DELETE * FROM usuario WHERE usuario_id = ?";
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
	
	public void removerPorTipoUsuario(VO vo) {
		String sql = "DELETE * FROM usuario WHERE usuario_tipousuario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getTipoUsuario());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removerPorNome(VO vo) {
		String sql = "DELETE * FROM usuario WHERE usuario_nome = ?";
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
	
	public void removerTudo() {
		String sql = "DELETE * FROM usuario";
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
		String sql = "SELECT * FROM usuario";
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
	
	public ResultSet buscarPorTipoUsuario(VO vo) {
		String sql = "SELECT * FROM usuario WHERE usuario_tipousuario = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1,vo.getTipoUsuario());
			rs = ptst.executeQuery(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet buscarPorNome(VO vo) {
		String sql = "SELECT * FROM usuario WHERE pessoa_nome = ?";
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
	
	public ResultSet buscarPorId(VO vo) {
		String sql = "SELECT * FROM usuario WHERE usuario_id = ?";
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
	
	public ResultSet buscarPorCpf(VO vo) {
		String sql = "SELECT * FROM usuario WHERE pessoa_cpf = ?";
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
	
	public ResultSet buscarPorLogin(VO vo) {
		String sql = "SELECT * FROM usuario WHERE usuario_login = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1,vo.getLogin());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
	
	public void editar(VO vo) {
		String sql = "UPDATE usuario SET pessoa_nome = ? where usuario_id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void editarLogin(VO vo) {
		String sql = "UPDATE usuario SET usuario_login = ? where usuario_id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getLogin());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void editarCpf(VO vo) {
		String sql = "UPDATE usuario SET pessoa_cpf = ? where usuario_id = ?";
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
	
	
	public void editarSenha(VO vo) {
		String sql = "UPDATE usuario SET usuario_login = ? where usuario_id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getSenha());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void editarTipoUsuario(VO vo) {
		String sql = "UPDATE usuario SET usuario_tipousuario = ? where usuario_id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getTipoUsuario());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}