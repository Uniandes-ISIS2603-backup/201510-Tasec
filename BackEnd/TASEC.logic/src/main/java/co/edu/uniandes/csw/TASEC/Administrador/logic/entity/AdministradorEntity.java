package co.edu.uniandes.csw.TASEC.Administrador.logic.entity;

import co.edu.uniandes.csw.TASEC.Informacion.logic.entity.InformacionEntity;
import co.edu.uniandes.csw.TASEC.Usuario.logic.entity.UsuarioEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class AdministradorEntity extends UsuarioEntity{

    @OneToMany
    private List<InformacionEntity> informacion;
   
    public List<InformacionEntity> getInformacion() {
        return informacion;
    }

    public void setInformacion(List<InformacionEntity> informacion) {
        this.informacion = informacion;
    }
}
