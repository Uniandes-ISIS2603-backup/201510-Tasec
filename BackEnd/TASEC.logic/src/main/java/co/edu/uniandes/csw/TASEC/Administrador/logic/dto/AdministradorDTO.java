package co.edu.uniandes.csw.TASEC.Administrador.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdministradorDTO {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}