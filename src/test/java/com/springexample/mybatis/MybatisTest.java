package com.springexample.mybatis;

import com.springexample.mybatis.mapper.PersonMapper;
import com.springexample.mybatis.mapper.SearchCriteria;
import com.springexample.persistence.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Ady on 2/14/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mybatis.xml"})
@Transactional
public class MybatisTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testMapper() {
        Assert.notNull(personMapper);
    }

    @Test
    public void getPerson() {
        List<Person> personList = personMapper.getPersonList(2L);
        System.out.println(personList.size());
    }

    @Test
    public void search() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setLastName("Vashisht".toLowerCase());
        List<Person> personList = personMapper.search(criteria);
        System.out.println(personList.size());
    }
}
