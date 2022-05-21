package model.vo;

public class ClienteVO extends UsuarioVO{
	
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id==null || id < 0) {
			
		} else {
			this.id = id;	
		}
	}
	
	public int getTipoUsuario() {
    
        return super.getTipoUsuario();
    }

    public void setTipoUsuario(int tipoUsuario) {
        if(tipoUsuario != 2){

        }else {
            super.setTipoUsuario(tipoUsuario);
        }
    }
	
}
