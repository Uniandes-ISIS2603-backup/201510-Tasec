package co.edu.uniandes.csw.TASEC.cliente.logic.entity;

import co.edu.uniandes.csw.TASEC.Factura.logic.entity.FacturaEntity;
import co.edu.uniandes.csw.TASEC.Usuario.logic.entity.UsuarioEntity;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
//@DiscriminatorValue("Cliente")
public class ClienteEntity extends UsuarioEntity {
    
    private int saldo;
    private int tarjetaDeCredito;
    private String direccion;
    private int telefono;
    @OneToMany
    private List<FacturaEntity> comprasRealizadas;

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    public void setTarjetaDeCredito(int tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int getTelefono() {
        return telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public List<FacturaEntity> getComprasRealizadas(){
            return comprasRealizadas;
    }
    
    public void setComprasRealizadas(List<FacturaEntity> compras){
        this.comprasRealizadas=compras;
    }


}
