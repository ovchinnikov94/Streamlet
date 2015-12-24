package main.implementations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitry on 1.12.15.
 */
public class Cluster {
    private Collector collector;
    private List<TopologyDefault> topologies;
    private List<Worker> workers;
    private Settings settings;

    public  Cluster(Settings settings){
        this.collector = new Collector();
        this.topologies = new ArrayList<TopologyDefault>();
        this.settings = settings;
        this.workers = new ArrayList<Worker>();
        for (int i = 0; i < settings.getWorkerNumber(); i++)
            this.workers.add(new Worker());
    }

    public void deployTopology(TopologyDefault topologyDefault){
        this.topologies.add(topologyDefault);
    }

    public void setWorkerNumber(int workerNumber) {
        this.settings.setWorkerNumber(workerNumber);
    }

    public void startCluster(){
        for (int i = 0; i < settings.getWorkerNumber(); i++) {
            for (int j = 0; j < topologies.size(); j++) {
                workers.get(i).setTopologyDefault(topologies.get(j));
                workers.get(i).start();
            }
        }
    }

    public void stopCluster(){
        for (Worker worker : workers)
            worker.stop();
    }

}
