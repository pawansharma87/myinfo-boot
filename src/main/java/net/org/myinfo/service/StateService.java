package net.org.myinfo.service;

import net.org.myinfo.model.State;

public interface StateService {
    Iterable<State> listAllStates();

    State getStateById(Integer id);

    State saveState(State state);

    void deleteState(Integer id);
}
