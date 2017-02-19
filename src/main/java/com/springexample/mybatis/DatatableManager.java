package com.springexample.mybatis;


import com.springexample.datatable.helper.DataTablePageCriteria;
import com.springexample.mybatis.mapper.PersonMapper;

import com.springexample.persistence.dto.PersonDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Ady on 2/19/17.
 */
@Component
public class DatatableManager {

    @Autowired
    PersonMapper personMapper;


    public Page<PersonDTO> getAllPersons(DataTablePageCriteria pageCriteria) {

        List<PersonDTO> persons = personMapper.getForTable(pageCriteria);

        int count = 0;
        if (!CollectionUtils.isEmpty(persons)) {
            PersonDTO personDTO = persons.get(0);
            count = personDTO.getTotal();


        }
        return new PageImpl(persons, pageCriteria.getPageRequest(), count);
    }
}
