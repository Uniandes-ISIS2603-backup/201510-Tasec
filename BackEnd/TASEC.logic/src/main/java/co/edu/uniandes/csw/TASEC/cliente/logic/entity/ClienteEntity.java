package co.edu.uniandes.csw.TASEC.Cliente.logic.entity;

import co.edu.uniandes.csw.TASEC.Usuario.logic.entity.UsuarioEntity;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClienteEntity extends UsuarioEntity {

    @Id
    @GeneratedValue(generator = "Country")
    private int saldo;
    private int tarjetaDeCredito;
    private String direccion;
    private int telefono;
    private ArrayList<FacturaEntity> comprasRealizadas;
    public Carrito carrito;

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
    
    public ArrayList<FacturaEntity> getComprasRealizadas(){
            return comprasRealizadas;
    }
    
    public void setComprasRealizadas(ArrayList<FacturaEntity> compras){
        this.comprasRealizadas=compras;
    }


}
