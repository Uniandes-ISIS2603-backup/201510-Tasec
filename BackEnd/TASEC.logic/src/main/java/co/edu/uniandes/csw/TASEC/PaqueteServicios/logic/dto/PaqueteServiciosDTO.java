package co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.dto;

import co.edu.uniandes.csw.TASEC.Servicio.logic.dto.ServicioDTO;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.entity.ServicioSimpleEntity;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaqueteServiciosDTO extends ServicioDTO {
    public int cupos;
    public int cuposrestantes;
    public ArrayList<ServicioSimpleEntity> servicios;

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

    public ArrayList<ServicioSimpleEntity> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<ServicioSimpleEntity> servicios) {
        this.servicios = servicios;
    }
}