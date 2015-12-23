package main.implementations;

import main.intefaces.StreamletBolt;
import main.intefaces.StreamletSpout;

/**
 * Created by dmitry on 22.12.15.
 */
public class Worker extends Thread {

    private Collector collector;
    private  Topology topology;

    public Worker(Collector collector, Topology topology){
        this.collector = collector;
        this.topology = topology;
    }

    @Override
    public void run(){
        
    }
}
