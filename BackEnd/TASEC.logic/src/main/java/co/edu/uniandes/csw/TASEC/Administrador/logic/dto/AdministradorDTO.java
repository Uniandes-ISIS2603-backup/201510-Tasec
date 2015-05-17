package co.edu.uniandes.csw.TASEC.Administrador.logic.dto;

import co.edu.uniandes.csw.TASEC.Informacion.logic.dto.InformacionDTO;
import co.edu.uniandes.csw.TASEC.Usuario.logic.dto.UsuarioDTO;
import java.util.List;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdministradorDTO extends UsuarioDTO{
    
    @OneToMany
    private List<InformacionDTO> informacion;

    public List<InformacionDTO> getInformacion() {
        return informacion;
    }

    public void setInformacion(List<InformacionDTO> informacion) {
        this.informacion = informacion;
    }
}