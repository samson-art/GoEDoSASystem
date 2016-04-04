package ru.mephi.goedosa.dao;

import ru.mephi.goedosa.dao.abstracts.AbstractJDBCDAO;
import ru.mephi.goedosa.entity.Entry;
import ru.mephi.goedosa.exceptions.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artemsamsonov on 16.03.16.
 */
public class EntryDAOImpl extends AbstractJDBCDAO<Entry> implements ru.mephi.goedosa.dao.interfaces.EntryDAO {

    public EntryDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getUpdatedQuery() {
        return null;
    }

    @Override
    public String getCreatedQuery() {
        return null;
    }

    @Override
    public String getDeletedQuery() {
        return null;
    }

    @Override
    protected List<Entry> parseResultSet(ResultSet rs) throws PersistException {
        ArrayList<Entry> entryList = new ArrayList<Entry>();
        try {
            while (rs.next()) {
                Entry entry = new Entry();
                entry.setTermin(rs.getString("termin"));
                entry.setDefinition(rs.getString("determination"));
                entryList.add(entry);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return entryList;
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stm, Entry object) {
        //TODO
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement preparedStatement, Entry object) throws PersistException {
        //TODO
    }

    @Override
    public String getSelectedQuery() {
        return  "SELECT termin, determination " +
                "FROM entries " +
                "JOIN entry_to_definitions " +
                "ON entries.id = entry_to_definitions.entry_id " +
                "JOIN definitions " +
                "ON definitions.id = entry_to_definitions.determination_id";
    }

    public List<Entry> getTermins(String query) throws PersistException {
        String sql = getSelectedQuery() + " WHERE termin LIKE '"+ query + "%'";
        List<Entry> list = null;
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return list;
    }

}
