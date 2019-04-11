package service.interfaces;

import entity.SGroup;
import exceptions.SGroupException;

import java.util.List;

public interface ISGroupService {
    void insert(SGroup sGroup) throws SGroupException;
    void update(SGroup sGroup) throws SGroupException;
    void delete(int id) throws SGroupException;
    List<SGroup> get();
    SGroup get(int id);

}
