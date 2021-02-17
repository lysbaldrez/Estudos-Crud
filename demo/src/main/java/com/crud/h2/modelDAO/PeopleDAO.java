package com.crud.h2.modelDAO;

import com.crud.h2.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PeopleDAO implements IPeople{

    People p1 = new People();
    People p2 = new People();

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<People> list() {
        String sql="select * from people";
        List<People>people=template.query(sql, new BeanPropertyRowMapper<People>(People.class));
        return people;
    }

    @Override
    public People listPeopleId(int id) {
        String sql="select * from people where id=?";
        People peo=template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<People>(People.class));
        return peo;
    }

    @Override
    public List<People> listPeopleName() {
        String sql="select * from people";
        List<People> peopleList = new ArrayList<>();
        peopleList.addAll(template.query(sql, new BeanPropertyRowMapper<People>(People.class)));
        return peopleList;
    }

    @Override
    public int add(People p) {
        String sql="insert into people(name)values(?)";
        int res=template.update(sql,p.getName());
        return res;


    }

    @Override
    public int edit(People p) {
        String sql="update people set name=? where id=?";
        int res=template.update(sql,p.getName(),p.getId());
        return res;
    }

    @Override
    public void delete(int id) {
        String sql="delete from people where id=?";
        template.update(sql,id);
    }
}
