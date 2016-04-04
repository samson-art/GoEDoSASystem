package ru.mephi.goedosa.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mephi.goedosa.dao.abstracts.AbstractJDBCDAO;
import ru.mephi.goedosa.dao.interfaces.DefinitionDAO;
import ru.mephi.goedosa.entity.Definition;
import ru.mephi.goedosa.exceptions.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * Created by artemsamsonov on 04.04.16.
 */
public class DefinitionDAOImpl extends AbstractJDBCDAO<Definition> implements DefinitionDAO {

    private static final Logger logger = LoggerFactory.getLogger(DefinitionDAOImpl.class);

    private enum Field {
        Sost, Name, Homo, Define, Dash, Literature, Content, Rank, Rank2, Small,
        Short, IsShort, England, History, DateLoad, Secret, NameFind, NameSort,
        DefineEdit, Rubric, UUID, UUIDPar, UUODRef
    }

//    private static String[] cols = {
//        "Sost", "Name", "Homo", "Define", "Dash", "Literature", "Content", "Rank", "Rank2", "Small",
//        "Short", "IsShort", "England", "History", "DateLoad", "Secret", "NameFind", "NameSort",
//        "DefineEdit", "Rubric", "UUID", "UUIDPar", "UUODRef"
//    };

    private static Map<Field, String> COLSNAMES = Collections.unmodifiableMap(
        new HashMap<Field, String>() {{
            put(Field.Sost, "sost");
            put(Field.Name, "Name");
            put(Field.Homo, "homo");
            put(Field.Define, "define");
            put(Field.Dash, "dash");
            put(Field.Literature, "literature");
            put(Field.Content, "Content");
            put(Field.Rank, "Rank");
            put(Field.Rank2, "rank2");
            put(Field.Small, "small");
            put(Field.Short, "short");
            put(Field.IsShort, "isshort");
            put(Field.England, "england");
            put(Field.History, "history");
            put(Field.DateLoad, "dateload");
            put(Field.Secret, "secret");
            put(Field.NameFind, "namefind");
            put(Field.NameSort, "namesort");
            put(Field.DefineEdit, "defineedit");
            put(Field.Rubric, "rub");
            put(Field.UUID, "uuid");
            put(Field.UUIDPar, "uuidpar");
            put(Field.UUODRef, "uuidref");
        }}
    );

    @Override
    protected List<Definition> parseResultSet(ResultSet rs) throws PersistException {
        ArrayList<Definition> list = new ArrayList<Definition>();
        logger.info("\n-----------------------------------------------\n");
        logger.info("Definition list:\n");
        try {
            while (rs.next()) {
                Definition d = new Definition();
                d.setSost(rs.getInt(COLSNAMES.get(Field.Sost)));
                d.setName(rs.getString(COLSNAMES.get(Field.Name)));
                d.setHomo(rs.getInt(COLSNAMES.get(Field.Homo)));
                d.setDefine(rs.getString(COLSNAMES.get(Field.Define)));
                d.setDash(rs.getString(COLSNAMES.get(Field.Dash)));
                //TODO Literature&Contents
                d.setRank(rs.getInt(COLSNAMES.get(Field.Rank)));
                d.setRank2(rs.getString(COLSNAMES.get(Field.Rank2)));
                d.setSmall(rs.getString(COLSNAMES.get(Field.Small)));
                d.setShortt(rs.getString(COLSNAMES.get(Field.Short)));
                d.setIsshort(rs.getInt(COLSNAMES.get(Field.IsShort)));
                d.setEngland(rs.getString(COLSNAMES.get(Field.England)));
                d.setHistory(rs.getString(COLSNAMES.get(Field.History)));
                d.setDateLoad(rs.getDate(COLSNAMES.get(Field.DateLoad)));
                d.setSecret(rs.getInt(COLSNAMES.get(Field.Secret)));
                d.setNameFind(rs.getString(COLSNAMES.get(Field.NameFind)));
                d.setNameSort(rs.getString(COLSNAMES.get(Field.NameSort)));
                d.setDefineEdit(rs.getString(COLSNAMES.get(Field.DefineEdit)));
                d.setRub(rs.getString(COLSNAMES.get(Field.Rubric)));
                d.setUuid(rs.getString(COLSNAMES.get(Field.UUID)));
                d.setUuidPar(rs.getString(COLSNAMES.get(Field.UUIDPar)));
                d.setUuidRef(rs.getString(COLSNAMES.get(Field.UUODRef)));
                list.add(d);

                logger.info(d.toString());

            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        logger.info("\n-----------------------------------------------\n");
        return list;
    }

    @Override
    public String getSelectedQuery() {
        return "SELECT * FROM definition";
    }

    @Override
    public String getUpdatedQuery() {
        //TODO
        return null;
    }

    @Override
    public String getCreatedQuery() {
        //TODO
        return null;
    }

    @Override
    public String getDeletedQuery() {
        //TODO
        return null;
    }


    @Override
    protected void prepareStatementForUpdate(PreparedStatement stm, Definition object) {
        //TODO
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement preparedStatement, Definition object) throws PersistException {
        //TODO
    }

    public DefinitionDAOImpl(Connection connection) {
        super(connection);
    }
}
