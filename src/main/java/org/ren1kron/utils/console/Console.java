package org.ren1kron.utils.console;

import java.io.BufferedReader;

public interface Console {
    void print(Object obj);
    void println(Object obj);
    void printerr(Object obj);
    void printGritting(Object obj);

    String readln();
    void setReader(BufferedReader reader);
    BufferedReader getReader();
}
