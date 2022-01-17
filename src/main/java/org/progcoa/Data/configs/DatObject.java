package org.progcoa.Data.configs;

import org.progcoa.Data.configuration;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class DatObject implements Serializable {

    private Map<String, Object> map = new HashMap<>();
    private String path;

    public DatObject(){
        this("data.dat");
    }

    public DatObject(String path){
        this.path = path;

        load();
    }

    public void setData(String key, Object value){
        map.put(key, value);
    }

    public Object getData(String key){
        return map.get(key);
    }

    public void setMap(Map<String, Object> map){
        this.map = map;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void save(){
        configuration.Save(map, path);
    }

    public void load(){
        if(configuration.Load(path) != null) this.map = (Map<String, Object>) configuration.Load(path);
    }
}
