package ru.mephi.goedosa.entity;

import java.sql.Date;

/**
 * Created by artemsamsonov on 04.04.16.
 */
public class Definition extends ru.mephi.goedosa.entity.Entity {

//    enum IsShort {
//        Default,            //аббревиатура термина (по умолчанию)
//        Short,              //сокращение термина (обычно сложносокращенные слова, например, военкомат,
//                            //Всероглавштаб, ВЧ-связь)
//        Intolerable,        //недопустимый или нерекомендуемый термин или совокупность таких терминов,
//                            //разделенных запятой (предшествует слово «Ндп.» или «Нрк.»);
//        Notation,           //обозначение термина (как правило, математическое);
//        Date,               //дата рождения или годы жизни человека
//        SubjectArea,        //предметная область (например, «воен.»);
//        Others              //остальные случаи
//    }

    private int sost;
    private String name;
    private int homo;
    private String define;
    private String dash;
    private Literature literature;
    private Content content;
    private int rank;
    private String rank2;
    private String small;
    private String shortt;
    private int isshort;
    private String england;
    private String history;
    private Date dateLoad;
    private int secret;
    private String nameFind;
    private String nameSort;
    private String defineEdit;
    private String rub;
    private String uuid;
    private String uuidPar;
    private String uuidRef;

    //getset
    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getDash() {
        return dash;
    }

    public void setDash(String dash) {
        this.dash = dash;
    }

    public Date getDateLoad() {
        return dateLoad;
    }

    public void setDateLoad(Date dateLoad) {
        this.dateLoad = dateLoad;
    }

    public String getDefine() {
        return define;
    }

    public void setDefine(String define) {
        this.define = define;
    }

    public String getDefineEdit() {
        return defineEdit;
    }

    public void setDefineEdit(String defineEdit) {
        this.defineEdit = defineEdit;
    }

    public String getEngland() {
        return england;
    }

    public void setEngland(String england) {
        this.england = england;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getHomo() {
        return homo;
    }

    public void setHomo(int homo) {
        this.homo = homo;
    }

    public int getIsshort() {
        return isshort;
    }

    public void setIsshort(int isshort) {
        this.isshort = isshort;
    }

    public Literature getLiterature() {
        return literature;
    }

    public void setLiterature(Literature literature) {
        this.literature = literature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameFind() {
        return nameFind;
    }

    public void setNameFind(String nameFind) {
        this.nameFind = nameFind;
    }

    public String getNameSort() {
        return nameSort;
    }

    public void setNameSort(String nameSort) {
        this.nameSort = nameSort;
    }

    public String getRank2() {
        return rank2;
    }

    public void setRank2(String rank2) {
        this.rank2 = rank2;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getRub() {
        return rub;
    }

    public void setRub(String rub) {
        this.rub = rub;
    }

    public int getSecret() {
        return secret;
    }

    public void setSecret(int secret) {
        this.secret = secret;
    }

    public String getShortt() {
        return shortt;
    }

    public void setShortt(String shortt) {
        this.shortt = shortt;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public int getSost() {
        return sost;
    }

    public void setSost(int sost) {
        this.sost = sost;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuidPar() {
        return uuidPar;
    }

    public void setUuidPar(String uuidPar) {
        this.uuidPar = uuidPar;
    }

    public String getUuidRef() {
        return uuidRef;
    }

    public void setUuidRef(String uuidRef) {
        this.uuidRef = uuidRef;
    }

    @Override
    public String toString() {
        return "Definition{" +
                "define='" + define + '\'' +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
