package model.vo;

public class AdministradorVO extends UsuarioVO{
	private Long id;
	
	public int getTipoUsuario() {
        return super.getTipoUsuario();
    }

    public void setTipoUsuario(int tipoUsuario) {
        if(tipoUsuario != 0){

        }else {
            super.setTipoUsuario(tipoUsuario);
        }
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id==null || id < 0) {
			
		} else {
			this.id = id;	
		}
	}
}
