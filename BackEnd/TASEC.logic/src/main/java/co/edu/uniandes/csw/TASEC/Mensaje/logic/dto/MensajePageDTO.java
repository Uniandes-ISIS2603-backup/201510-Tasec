/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Mensaje.logic.dto;

import java.util.List;

/**
 *
 * @author josedanielcardenasrincon
 */
public class MensajePageDTO {
    private Long totalRecords;

    private List<MensajeDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<MensajeDTO> getRecords() {
        return records;
    }

    public void setRecords(List<MensajeDTO> records) {
        this.records = records;
    }
}
