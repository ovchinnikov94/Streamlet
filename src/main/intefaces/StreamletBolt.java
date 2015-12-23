package main.intefaces;

/**
 * Created by dmitry on 25.11.15.
 */
public interface StreamletBolt {
    String name = null;
    public void init();
    public void beforeTerminate();
    public void exec();
}
