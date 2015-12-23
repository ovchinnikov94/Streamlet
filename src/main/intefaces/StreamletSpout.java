package main.intefaces;

/**
 * Created by dmitry on 25.11.15.
 */
public interface StreamletSpout {
    String name = null;
    public void init();
    public void nextTuple();
    public void beforeTerminate();
}
