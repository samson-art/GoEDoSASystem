package ru.mephi.goedosa.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mephi.goedosa.dao.interfaces.DAOFactory;
import ru.mephi.goedosa.dao.interfaces.DefinitionDAO;
import ru.mephi.goedosa.exceptions.PersistException;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by artemsamsonov on 27.11.15.
 */
@Singleton
public class PostgreSQLDAOFactory implements DAOFactory {

    private static final Logger logger = LoggerFactory.getLogger(PostgreSQLDAOFactory.class);

//    private static final String DBUSER = "sgoedosaadmin";
//    private static final String DBPASSWORD = "password";
//    private static final String DBURL = "jdbc:postgresql://localhost:5432/sgoedosa";
//    private static final String DBDRIVER = "org.postgresql.Driver";

    public UserDAOImpl getUserDAO() throws PersistException {
        return new UserDAOImpl(getConnection());
    }

    public EntryDAOImpl getEntryDAO() throws PersistException {
        return new EntryDAOImpl(getConnection());
    }

    public DefinitionDAO getDefinitionDAO() throws PersistException {
        return new DefinitionDAOImpl(getConnection());
    }

    public Connection getConnection() throws PersistException {
        String user = "sgoedosaadmin";
        String password = "password";
        String url = "jdbc:postgresql://localhost:5432/sgoedosa";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @PostConstruct
    private void init() {
        try {
            Class.forName("org.postgresql.Driver");
            logger.info("Driver registered!");
            logger.info("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
