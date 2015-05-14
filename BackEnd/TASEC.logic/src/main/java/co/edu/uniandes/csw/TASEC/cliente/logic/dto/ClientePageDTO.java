package co.edu.uniandes.csw.TASEC.cliente.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import co.edu.uniandes.csw.TASEC.cliente.logic.dto.ClienteDTO;

@XmlRootElement
public class ClientePageDTO {
    private Long totalRecords;

    private List<ClienteDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<ClienteDTO> getRecords() {
        return records;
    }

    public void setRecords(List<ClienteDTO> records) {
        this.records = records;
    }
}
