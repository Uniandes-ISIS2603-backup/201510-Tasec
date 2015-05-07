/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Informacion.logic.dto;

/**
 *
 * @author josedanielcardenasrincon
 */
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InformacionPageDTO {
    
    private Long totalRecords;

    private List<InformacionDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<InformacionDTO> getRecords() {
        return records;
    }

    public void setRecords(List<InformacionDTO> records) {
        this.records = records;
    }
}
