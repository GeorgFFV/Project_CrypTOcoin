package model.vo;

public class UsuarioVO extends PessoaVO {

  private String login;
  private String senha;
  private int tipoUsuario;// [0]Administrador || [1] Cliente
  private Long id;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    if (login == null || login.equals("") || login.length() < 2) {

    } else {
      this.login = login;
    }
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    if (senha == null || senha.equals("") || senha.length() < 3) {

    } else {
      this.senha = senha;
    }
  }

  public int getTipoUsuario() {
    return tipoUsuario;
  }

  public void setTipoUsuario(int tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    if (id == null || id < 0) {

    } else {
      this.id = id;
    }
  }
}