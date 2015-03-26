package co.edu.uniandes.csw.TASEC.Cliente.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteDTO {
    private Long id;

    private String name;

    private Integer population;

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

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}