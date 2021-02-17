package com.crud.h2.service;

import com.crud.h2.model.People;

import java.util.List;

public interface IPeopleService {

    public List<People> list();

    public People listPeopleId(int id);

    public List<People> listPeopleName();

    public People add(People p);

    public int edit(People p);

    public void delete(int id);
}
