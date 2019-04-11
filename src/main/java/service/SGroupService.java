package service;

import entity.SGroup;
import exceptions.SGroupException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.interfaces.IRepository;
import service.interfaces.ISGroupService;

import java.util.List;

@Component
public class SGroupService implements ISGroupService {
    @Autowired
    IRepository<SGroup> repository;

    public void setRepository(IRepository repository) {
        this.repository = repository;
    }


    @Override
    public void insert(SGroup sGroup) throws SGroupException {
        if (!repository.insert(sGroup))
            throw new SGroupException("SGroup don't insert");

    }

    @Override
    public void update(SGroup sGroup) throws SGroupException {
        if (!repository.update(sGroup))
            throw new SGroupException("SGroup don't update");
    }

    @Override
    public void delete(int id) throws SGroupException {
        if (!repository.delete(id))
            throw new SGroupException("SGroup don't delete");
    }

    @Override
    public List<SGroup> get() {
        return repository.get();
    }

    @Override
    public SGroup get(int id) {
        return repository.get(id);
    }

}

