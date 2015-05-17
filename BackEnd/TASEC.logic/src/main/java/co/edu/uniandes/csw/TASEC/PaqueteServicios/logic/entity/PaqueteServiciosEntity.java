package co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.entity;

import co.edu.uniandes.csw.TASEC.Servicio.logic.entity.ServicioEntity;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.entity.ServicioSimpleEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class PaqueteServiciosEntity extends ServicioEntity{

    //@GeneratedValue(generator = "Country")
    private int cupos;
    private int cuposrestantes;
    @ManyToMany
    private List<ServicioSimpleEntity> servicios;

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

     public int getCuposRestantes() {
        return cuposrestantes;
    }

    public void setCuposRestantes(int cuposrestantes) {
        this.cuposrestantes = cuposrestantes;
    }

    public List<ServicioSimpleEntity> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioSimpleEntity> servicios) {
        this.servicios = servicios;
    }
}
