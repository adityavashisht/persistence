package com.springexample.mybatis.mapper;

import com.springexample.datatable.helper.DataTablePageCriteria;
import com.springexample.persistence.domain.Person;
import com.springexample.persistence.dto.PersonDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Ady on 2/14/17.
 */
public interface PersonMapper {

    List<Person> getPersonList(@Param("id") Long id);

    List<PersonDTO> getForTable(@Param("pageCriteria") DataTablePageCriteria pageCriteria);
}
