/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.ThreadForo.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josedanielcardenasrincon
 */
@XmlRootElement
public class ThreadForoDTO {
    
     private Long id;

    private String titulo;
    
    private String tema;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
