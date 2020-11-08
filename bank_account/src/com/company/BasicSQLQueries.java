package com.company;

import java.sql.Connection;
import java.util.List;
import java.util.ListIterator;

public interface BasicSQLQueries {
    Connection connectToDB();
    void insertToTable(String name, String email, String password);
    String[] extractData();
}
