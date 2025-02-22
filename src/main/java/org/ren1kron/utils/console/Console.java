package org.ren1kron.utils.console;

public interface Console {
    void print(Object obj);
    void println(Object obj);
    void printerr(Object obj);
    void printGritting(Object obj);

    String readln();
    boolean hasNextLine();
}
