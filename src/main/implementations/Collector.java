package main.implementations;

import main.intefaces.StreamletTuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dmitry on 22.12.15.
 */
public class Collector {
    Map<String, List<StreamletTuple>> tuples;
    Map<String, List<StreamletTuple>> tuplesResult;

    public Collector(){
        tuples = new HashMap<String, List<StreamletTuple>>();
        tuplesResult = new HashMap<String, List<StreamletTuple>>();
    }

    public StreamletTuple get(String name){
        List<StreamletTuple> list = this.tuples.get(name);
        if (list != null) {
            if (list.isEmpty()) return null;
            StreamletTuple tuple = list.get(0);
            list.remove(tuple);
            return tuple;
        }
        return null;
    }

    public void emit(String name, StreamletTuple tuple){
        List<StreamletTuple> list = this.tuplesResult.get(name);
        if (list == null){
            list = new ArrayList<StreamletTuple>();
            list.add(tuple);
            this.tuplesResult.put(name, list);
        }
        else {
            list.add(tuple);
        }
    }

    public void handleResult(String src, String dst){
        List<StreamletTuple> listSrc = this.tuplesResult.get(src);
        if (listSrc != null) {
            List<StreamletTuple> listDst = this.tuples.get(dst);
            if (listDst == null) listDst = new ArrayList<StreamletTuple>();
            listDst.addAll(listSrc);
            listSrc.clear();
            this.tuples.put(dst, listDst);
        }
    }
}
