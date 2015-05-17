package co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.dto;

import co.edu.uniandes.csw.TASEC.Servicio.logic.dto.ServicioDTO;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.dto.ServicioSimpleDTO;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaqueteServiciosDTO extends ServicioDTO {
    public int cupos;
    public int cuposrestantes;
    public List<ServicioSimpleDTO> servicios;

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

     public int getCuposRestantes() {
        return cupos;
    }

    public void setCuposRestantes(int cuposrestantes) {
        this.cuposrestantes = cuposrestantes;
    }

    public List<ServicioSimpleDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioSimpleDTO> servicios) {
        this.servicios = servicios;
    }
}