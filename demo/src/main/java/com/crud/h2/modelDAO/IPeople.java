package com.crud.h2.modelDAO;

import com.crud.h2.model.People;

import java.util.List;

public interface IPeople {
    public List<People> list();

    public List<People> listPeopleName();

    public People listPeopleId(int id);

    public int add(People p);

    public int edit(People p);

    public void delete(int id);
}
