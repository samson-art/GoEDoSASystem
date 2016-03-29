package ru.mephi.goedosa.bean.entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mephi.goedosa.DAO.interfaces.DAOFactory;
import ru.mephi.goedosa.DAO.interfaces.EntryDAO;
import ru.mephi.goedosa.entity.Entry;
import ru.mephi.goedosa.exceptions.PersistException;

import javax.ejb.EJB;
import java.io.Serializable;
import java.util.List;

/**
 * Created by artemsamsonov on 16.03.16.
 */
public abstract class AbstractEntryBean implements Serializable {
    protected static final Logger logger = LoggerFactory.getLogger(AbstractEntryBean.class);

    @EJB
    private DAOFactory daoFactory;

    protected EntryDAO entryDAO;

    protected void init(){
        try {
            entryDAO = daoFactory.getEntryDAO();
            getFields();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    protected abstract void getFields();
    protected abstract void find();
    protected abstract List<String> getTermins(String query) throws PersistException;
}
