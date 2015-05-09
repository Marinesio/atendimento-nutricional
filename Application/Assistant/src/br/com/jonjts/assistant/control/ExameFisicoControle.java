/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.control;

import br.com.jonjts.assistant.persistence.ExameFisicoPersistencia;
import br.com.jonjts.assistant.persistence.PacientePersistencia;
import br.com.jonjts.assistant.entity.ExameFisico;
import br.com.jonjts.assistant.entity.Paciente;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class ExameFisicoControle implements IControl<ExameFisico> {

    private ExameFisicoPersistencia exameFisicoDAO;

    public void setExameFisicoDAO(ConnectionSource connectionSource) throws SQLException {
        getExameFisicoDAO();
        exameFisicoDAO.setConnectionSource(connectionSource);
    }

    private ExameFisicoPersistencia getExameFisicoDAO() throws SQLException {
        if (exameFisicoDAO == null) {
            exameFisicoDAO = new ExameFisicoPersistencia();
        }
        return exameFisicoDAO;
    }

    @Override
    public ExameFisico insert(ExameFisico object) throws Exception {
       getExameFisicoDAO().persist(object);
        return getExameFisicoDAO().getLast("id");
    }

    @Override
    public List<ExameFisico> getAll() throws Exception {
        return getExameFisicoDAO().listAll();
    }

    @Override
    public void delete(Number id) throws Exception {
        getExameFisicoDAO().deleteById(id.longValue());
    }

    @Override
    public void update(ExameFisico object) throws Exception {
        getExameFisicoDAO().update(object);
    }

    @Override
    public ExameFisico get(Number id) throws Exception {
        return getExameFisicoDAO().findById(id.longValue());
    }

    public ExameFisico get(Long idExameClinico) throws Exception {
        QueryBuilder<ExameFisico, Long> queryBuilder = getExameFisicoDAO().queryBuilder();
        queryBuilder.where().eq("id_exame_clinico", idExameClinico);
        return queryBuilder.queryForFirst();
    }
}
