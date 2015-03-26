package co.edu.uniandes.csw.TASEC.Administrador.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdministradorPageDTO {
    private Long totalRecords;

    private List<AdministradorDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<AdministradorDTO> getRecords() {
        return records;
    }

    public void setRecords(List<AdministradorDTO> records) {
        this.records = records;
    }
}
