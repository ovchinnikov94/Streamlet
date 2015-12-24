package main.implementations;

import main.intefaces.StreamletBolt;
import main.intefaces.StreamletSpout;
import main.intefaces.StreamletTopology;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmitry on 22.12.15.
 */
public class TopologyDefault implements StreamletTopology {
    private String topologyName;
    private Collector collector;
    private Map<String, StreamletSpout> spouts;
    private Map<String, StreamletBolt> bolts;
    private Map<String, String> associations;

    public TopologyDefault(String topologyName) {
        this.topologyName = topologyName;
        this.spouts = new HashMap<String, StreamletSpout>();
        this.bolts = new HashMap<String, StreamletBolt>();
        this.associations = new HashMap<String, String>();
        this.collector = new Collector();
    }

    public void setBolt(String name, StreamletBolt bolt){
        this.bolts.put(name, bolt);
    }

    public void setSpout(String name, StreamletSpout spout){
        this.spouts.put(name, spout);
    }

    public void setAssociation(String node1, String node2){
        this.associations.put(node1, node2);
    }

    public Map<String, StreamletSpout> getSpouts() {
        return spouts;
    }

    public Map<String, StreamletBolt> getBolts() {
        return bolts;
    }

    public Map<String, String> getAssociations() {
        return associations;
    }

    public String getTopologyName() {
        return topologyName;
    }

    public Collector getCollector() {
        return collector;
    }
}
