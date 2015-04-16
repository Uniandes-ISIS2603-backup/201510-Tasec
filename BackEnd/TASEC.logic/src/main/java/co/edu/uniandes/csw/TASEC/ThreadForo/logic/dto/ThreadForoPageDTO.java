/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.ThreadForo.logic.dto;

import java.util.List;

/**
 *
 * @author josedanielcardenasrincon
 */
public class ThreadForoPageDTO {
    private Long totalRecords;

    private List<ThreadForoDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<ThreadForoDTO> getRecords() {
        return records;
    }

    public void setRecords(List<ThreadForoDTO> records) {
        this.records = records;
    }
}
