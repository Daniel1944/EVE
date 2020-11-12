package com.company.interfaces;

public interface BasicInputOutput {
    void createFile(String name);
    void writeToFile(String name, String info);
    void readFile(String name);
    void writeErrorToFile(String info);

}
