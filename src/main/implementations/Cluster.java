package main.implementations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitry on 23.12.15.
 */
public class Cluster {
    private Collector collector;
    private List<Topology> topologies;
    private Settings settings;

    public  Cluster(){
        this.collector = new Collector();
        this.topologies = new ArrayList<Topology>();
        this.settings = new Settings();
    }

    public void deployTopology(Topology topology){
        this.topologies.add(topology);
    }

    public void startCluster(){

    }

    public void stopCluster(){

    }

}
