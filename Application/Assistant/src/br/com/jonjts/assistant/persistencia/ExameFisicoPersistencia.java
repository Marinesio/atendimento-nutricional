/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.persistencia;

import br.com.jonjts.assistant.dto.ExameFisico;
import br.com.jonjts.assistant.dto.Paciente;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class ExameFisicoPersistencia extends GenericPersistencia<ExameFisico, Long>{

    public ExameFisicoPersistencia() throws SQLException {
        super(DAO.instance().getConnectionSource(), ExameFisico.class);
    }
    
}
