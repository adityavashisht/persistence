package com.springexample.web.controller;

import com.springexample.datatable.DataTableRequest;
import com.springexample.datatable.DataTableResponse;
import com.springexample.datatable.helper.DataTableHelper;
import com.springexample.datatable.helper.DataTablePageCriteria;
import com.springexample.mybatis.DatatableManager;

import com.springexample.persistence.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ady on 2/19/17.
 */
@Controller
@RequestMapping("/datatable")
public class PersonDataTableController {

    @Autowired
    private DatatableManager datatableManager;

    @GetMapping
    public String dataTable() {
        return "person-datatable";// /WEB-INF/views/home.jsp"
    }

    /**
     * Request handler for server side processing - datatable
     *
     * @return
     */
    @RequestMapping(value = "/ajax", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<DataTableResponse> show(@RequestBody DataTableRequest dataTableRequest) {

        DataTablePageCriteria pageCriteria = DataTableHelper.forSortingAndPaging(dataTableRequest);
        Page<PersonDTO> personDTOPage = datatableManager.getAllPersons(pageCriteria);
        return new ResponseEntity<>(DataTableHelper.extract(personDTOPage), HttpStatus.OK);
    }
}
