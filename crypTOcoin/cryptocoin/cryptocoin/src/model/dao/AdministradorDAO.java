package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.AdministradorVO;

public class AdministradorDAO<VO extends AdministradorVO> extends BaseDAO<VO> {

  public void inserir(VO vo) {
    String sql = "INSERT INTO admnistrador(pessoa_nome,pessoa_cpf,administrador_id) values (?,?,?)";
    PreparedStatement ptst;
    try {
      ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      ptst.setString(1, vo.getNome());
      ptst.setString(2, vo.getCpf());
      ptst.setLong(3, vo.getId());

      int affectedRows = ptst.executeUpdate();

      if (affectedRows == 0) {
        throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
      }
      ResultSet generatedKeys = ptst.getGeneratedKeys();
      if (generatedKeys.next()) {
        vo.setId(generatedKeys.getLong(1));
      } else {
        throw new SQLException("A inser��o falhou. Nenhum Id foi retornado.");
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void remover(VO vo) {
    String sql = "DELETE * FROM administrador WHERE administrador_id = ?";
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
    String sql = "DELETE * FROM administrador";
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
    String sql = "SELECT * FROM administrador";
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
    String sql = "SELECT * FROM administrador WHERE administrador_id = ?";
    PreparedStatement ptst;
    ResultSet rs = null;
    try {
      ptst = getConnection().prepareStatement(sql);
      ptst.setLong(1, vo.getId());
      rs = ptst.executeQuery(sql);
    } catch (SQLException e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return rs;
  }

  public ResultSet buscarPorNome(VO vo) {
    String sql = "SELECT * FROM administrador WHERE pessoa_nome = ?";
    PreparedStatement ptst;
    ResultSet rs = null;
    try {
      ptst = getConnection().prepareStatement(sql);
      ptst.setString(1, vo.getNome());
      rs = ptst.executeQuery(sql);
    } catch (SQLException e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return rs;
  }

  public ResultSet buscarPorCpf(VO vo) {
    String sql = "SELECT * FROM administrador WHERE pessoa_cpf = ?";
    PreparedStatement ptst;
    ResultSet rs = null;
    try {
      ptst = getConnection().prepareStatement(sql);
      ptst.setString(1, vo.getCpf());
      rs = ptst.executeQuery(sql);
    } catch (SQLException e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return rs;
  }

  public void editar(VO vo) {
    String sql = "UPDATE administrador SET pessoa_nome = ? WHERE administrador_id = ?";
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

  public void editarCpf(VO vo) {
    String sql = "UPDATE administrador SET pessoa_cpf = ? WHERE administrador_id = ?";
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

  public void editarEndereco(VO vo) {
    String sql = "UPDATE administrador SET WHERE administrador_id = ?";
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
}

