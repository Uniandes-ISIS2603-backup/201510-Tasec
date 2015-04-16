/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.ThreadForo.logic.api;

import co.edu.uniandes.csw.TASEC.ThreadForo.logic.dto.ThreadForoDTO;
import co.edu.uniandes.csw.TASEC.ThreadForo.logic.dto.ThreadForoPageDTO;
import java.util.List;

/**
 *
 * @author josedanielcardenasrincon
 */
public interface IThreadForoLogic {
    
    public ThreadForoDTO createThreadForo(ThreadForoDTO detail);
    
    public List<ThreadForoDTO> getThreadForos();

    public ThreadForoPageDTO getThreadForos(Integer page, Integer maxRecords);

    public ThreadForoDTO getThreadForo(Long id);

    public void deleteThreadForo(Long id);

    public void updateThreadForo(ThreadForoDTO detail);
}
