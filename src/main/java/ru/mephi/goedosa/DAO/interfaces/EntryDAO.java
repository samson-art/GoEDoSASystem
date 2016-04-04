package ru.mephi.goedosa.dao.interfaces;

import ru.mephi.goedosa.entity.Entry;
import ru.mephi.goedosa.exceptions.PersistException;

import java.util.List;

/**
 * Created by artemsamsonov on 16.03.16.
 */
public interface EntryDAO extends GenericDAO<Entry> {
     public List<Entry> getTermins(String query) throws PersistException;
}
