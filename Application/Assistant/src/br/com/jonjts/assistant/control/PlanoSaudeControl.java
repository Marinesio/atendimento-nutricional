/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.control;

import br.com.jonjts.assistant.entity.PlanoSaude;
import br.com.jonjts.assistant.persistence.PlanoSaudePesistence;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class PlanoSaudeControl implements IControl<PlanoSaude>{

    private PlanoSaudePesistence pesistence;

    public PlanoSaudePesistence getPesistence() throws SQLException {
        if (pesistence == null) {
            pesistence = new PlanoSaudePesistence();
        }
        return pesistence;
    }

    @Override
    public PlanoSaude insert(PlanoSaude object) throws Exception {
        getPesistence().create(object);
        return getPesistence().getLast("id");
    }

    @Override
    public List<PlanoSaude> getAll() throws Exception {
        return getPesistence().listAll();
    }

    @Override
    public void delete(Number id) throws Exception {
        getPesistence().deleteById(id.longValue());
    }

    @Override
    public void update(PlanoSaude object) throws Exception {
        getPesistence().update(object);
    }

    @Override
    public PlanoSaude get(Number id) throws Exception {
        return getPesistence().findById(id.longValue());
    }

}
