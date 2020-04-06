package com.infoobjects.dao;

import java.util.HashMap;
import java.util.Map;

public class HotelDao<T, S>{
    private Map<T, S> hotelHashMap = new HashMap<>();

    public S read(T id) {
        return hotelHashMap.get(id);
    }

    public Map<T, S> readAll() {
        return hotelHashMap;
    }

    public void create(T id, S hotelDTO) /*throws Exception*/ {
        if (hotelHashMap.containsKey(id)) {
//            throw new Exception(String.format("A value for '%s' is already present.", id));
            throw new IllegalStateException(
                    String.format("A value for '%s' is already present.",id));
        }
        if (hotelDTO == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
        hotelHashMap.put(id,hotelDTO);
    }


    public void update(T id, S hotelDTO) {
        if (!hotelHashMap.containsKey(id)) {
            throw new IllegalStateException("There is no value to update for key '"+id+"'.");
        }
        if (hotelDTO == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
        hotelHashMap.put(id, hotelDTO);
    }

    public boolean delete(T id) {
        return hotelHashMap.remove(id)!=null;
    }

}



