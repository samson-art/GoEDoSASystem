package ru.mephi.exceptions;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public class PersistException extends Exception {
    public PersistException(Exception e) {
        super(e);
    }

    public PersistException(String s) {
        super(s);
    }
}
