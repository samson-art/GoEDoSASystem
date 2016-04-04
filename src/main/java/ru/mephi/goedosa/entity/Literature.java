package ru.mephi.goedosa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by artemsamsonov on 04.04.16.
 */
@Entity
@Table(name = "literature")
public class Literature implements Serializable {

//    enum Dict {
//        WARFARE,
//        DEFENSE,
//        IT,
//        NONWAR,
//        NULL
//    }
//
//    enum Secret {
//        SECRET,
//        NONSECRET,
//        ADMINUSE
//    }
//
//    enum IsWork {
//        PART,
//        FULL,
//        CONSIDERED
//    }

    @Id
    @Column(name = "code")
    private int code;

    @Column(name = "code", nullable = false)
    private String name;

    @Column(name = "codefirst")
    private int codeFirst;

    @Column(name = "codesecond")
    private int codeSecond;

    @Column(name = "codemain")
    private int codeMain;

    @Column(name = "short")
    private String shortt;

    @Column(name = "dict")
    private int dict;

    @Column(name = "nref")
    private int nref;

    //getset
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCodeFirst() {
        return codeFirst;
    }

    public void setCodeFirst(int codeFirst) {
        this.codeFirst = codeFirst;
    }

    public int getCodeMain() {
        return codeMain;
    }

    public void setCodeMain(int codeMain) {
        this.codeMain = codeMain;
    }

    public int getCodeSecond() {
        return codeSecond;
    }

    public void setCodeSecond(int codeSecond) {
        this.codeSecond = codeSecond;
    }

    public int getDict() {
        return dict;
    }

    public void setDict(int dict) {
        this.dict = dict;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNref() {
        return nref;
    }

    public void setNref(int nref) {
        this.nref = nref;
    }

    public String getShortt() {
        return shortt;
    }

    public void setShortt(String shortt) {
        this.shortt = shortt;
    }

    public Literature() {
    }
}
