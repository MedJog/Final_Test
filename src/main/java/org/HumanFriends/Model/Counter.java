package org.HumanFriends.Model;
import java.io.IOException;
public class Counter implements AutoCloseable{

    public static int counter = 0;
    private boolean condition = false;

    public Counter() {
        open();
    }

    public void add() throws IOException {
        if (!condition) throw new IOException();
        else counter++;
    }

    public void open() {
        condition = true;
    }

    public void close() {
        condition = false;
    }

    public int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Counter.counter = counter;
    }

}

