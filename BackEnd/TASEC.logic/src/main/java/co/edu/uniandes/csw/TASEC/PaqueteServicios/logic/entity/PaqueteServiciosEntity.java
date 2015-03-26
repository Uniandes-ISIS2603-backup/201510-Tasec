package co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.entity;

import co.edu.uniandes.csw.TASEC.Servicio.logic.entity.ServicioEntity;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.entity.ServicioSimpleEntity;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class PaqueteServiciosEntity extends ServicioEntity{

    @GeneratedValue(generator = "Country")
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
