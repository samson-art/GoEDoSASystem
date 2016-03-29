package ru.mephi.goedosa.bean.entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mephi.goedosa.entity.Entry;
import ru.mephi.goedosa.exceptions.PersistException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artemsamsonov on 16.03.16.
 */
@ManagedBean(name = "entryMB")
@RequestScoped
public class EntryBean extends AbstractEntryBean {

    private final Logger logger = LoggerFactory.getLogger(EntryBean.class);

    private List<Entry> entryList;
    private String searchQueryEntry;

    @Override
    protected void getFields() {
        try {
            entryList = entryDAO.getAll();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void find() {
        try {
            if (searchQueryEntry.length()==0) {
                entryList = entryDAO.getAll();
            } else {
                entryList = entryDAO.getTermins(searchQueryEntry);

                logger.info("\n========================================================================\n" +
                        "Find:\n" +
                        entryList.toString() +
                        "\n========================================================================\n");
            }
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    @Override
    protected void init() {
        super.init();
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public String getSearchQueryEntry() {
        return searchQueryEntry;
    }

    public void setSearchQueryEntry(String searchQueryEntry) {
        this.searchQueryEntry = searchQueryEntry;
    }

    @Override
    public List<String> getTermins(String query) {

        List<String> list = new ArrayList<String>();
        try {
            for(Entry e : entryDAO.getTermins(query)) {
                list.add(e.getTermin());
            }
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return list;
    }



}
