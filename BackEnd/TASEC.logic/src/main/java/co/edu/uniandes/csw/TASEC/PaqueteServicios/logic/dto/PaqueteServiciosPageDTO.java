package co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaqueteServiciosPageDTO {
    private Long totalRecords;

    private List<PaqueteServiciosDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<PaqueteServiciosDTO> getRecords() {
        return records;
    }

    public void setRecords(List<PaqueteServiciosDTO> records) {
        this.records = records;
    }
}
