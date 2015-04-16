/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Publicacion.logic.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author josedanielcardenasrincon
 */
public class PublicacionEntity {
    
    @Id
    @GeneratedValue(generator = "Publicacion")
    private Long id;
    private String contenido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
