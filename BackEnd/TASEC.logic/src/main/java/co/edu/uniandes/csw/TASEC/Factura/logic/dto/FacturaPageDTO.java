package co.edu.uniandes.csw.TASEC.Factura.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FacturaPageDTO {
    private Long totalRecords;

    private List<FacturaDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<FacturaDTO> getRecords() {
        return records;
    }

    public void setRecords(List<FacturaDTO> records) {
        this.records = records;
    }
}
