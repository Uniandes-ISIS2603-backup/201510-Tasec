package co.edu.uniandes.csw.TASEC.Cliente.logic.dto;

import co.edu.uniandes.csw.TASEC.Usuario.logic.dto.UsuarioDTO;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import co.edu.uniandes.csw.TASEC.Factura.logic.entity.FacturaEntity;

@XmlRootElement
public class ClienteDTO extends UsuarioDTO {
    private int saldo;
    private int tarjetaDeCredito;
    private String direccion;
    private int telefono;
    private ArrayList<FacturaEntity> comprasRealizadas;
    
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