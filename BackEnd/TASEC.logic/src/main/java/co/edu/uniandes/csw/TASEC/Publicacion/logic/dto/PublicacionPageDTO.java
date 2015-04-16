/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Publicacion.logic.dto;

import java.util.List;

/**
 *
 * @author josedanielcardenasrincon
 */
public class PublicacionPageDTO {
    private Long totalRecords;

    private List<PublicacionDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<PublicacionDTO> getRecords() {
        return records;
    }

    public void setRecords(List<PublicacionDTO> records) {
        this.records = records;
    }
}
