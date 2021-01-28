package com.crud.h2.service;

import com.crud.h2.model.People;
import com.crud.h2.modelDAO.IPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public int add(People p) {
        dao.add(p);
        return 0;
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
