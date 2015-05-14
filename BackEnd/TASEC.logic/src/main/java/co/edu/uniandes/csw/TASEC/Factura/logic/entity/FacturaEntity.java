package co.edu.uniandes.csw.TASEC.Factura.logic.entity;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FacturaEntity {

    @Id
    @GeneratedValue(generator = "Factura")
    private Long id;
    private Integer totalAPagar;
    private Date fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(Integer totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
}
