package com.crud.h2.service;

import com.crud.h2.model.People;
import com.crud.h2.modelDAO.IPeople;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService implements IPeopleService{

    @Autowired
    private IPeople dao;

    @Override
    public List<People> list() {
        return dao.list();
    }

    @Override
    public People listPeopleId(int id) {
        return dao.listPeopleId(id);
    }


    public List<People> listPeopleName() {
        return dao.listPeopleName();
    }

    // Condição é no service, o controller não serve para regras de negócio
    @Override
    public People add(People p)  {
        List<People> peopleList= listPeopleName();
        for (People people: peopleList) {
            if (p.getName().equals(people.getName())) {
                throw new IllegalArgumentException();
            }
        }
        dao.add(p);
        return p;
    }

    @Override
    public int edit(People p) {
        dao.edit(p);
        return 0;
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
