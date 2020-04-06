package com.infoobjects.services;

import java.util.Map;

public interface Service<S,T> {
    T read(S id);
    Map<S, T> readAll();
    void create(S id, T hotelDTO);
    void update(S id, T hotelDTO);
    void delete(S id);
}
