/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Informacion.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josedanielcardenasrincon
 */
@XmlRootElement
public class InformacionDTO {
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}