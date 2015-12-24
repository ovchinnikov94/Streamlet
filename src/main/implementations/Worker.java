package main.implementations;

import main.intefaces.StreamletBolt;
import main.intefaces.StreamletSpout;

import java.util.Map;

/**
 * Created by dmitry on 27.10.15.
 */
public class Worker extends Thread {

    private TopologyDefault topologyDefault;

    public Worker(TopologyDefault topologyDefault){
        this.topologyDefault = topologyDefault;
    }

    public Worker(){}

    public void setTopologyDefault(TopologyDefault topologyDefault) {
        this.topologyDefault = topologyDefault;
    }

    @Override
    public void run(){
        /**
         * Раздвоить на 2 потока
         * 1 поток обслуживает воронки
         * 2 поток обслуживает сита
         */
        while (true) {
            for (Map.Entry<String, StreamletSpout> entry : topologyDefault.getSpouts().entrySet())
                entry.getValue().nextTuple();
            for (Map.Entry<String, StreamletBolt> entry : topologyDefault.getBolts().entrySet())
                entry.getValue().exec();
            for (Map.Entry<String, String> entry : topologyDefault.getAssociations().entrySet())
                topologyDefault.getCollector().handleResult(entry.getKey(), entry.getKey());
        }
    }
}
