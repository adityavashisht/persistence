package com.springexample.datatable.helper;


import com.springexample.datatable.DataTableRequest;
import com.springexample.datatable.DataTableResponse;
import com.springexample.datatable.SortColumnDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by vashishta on 5/10/15.
 */
public class DataTableHelper {

    /**
     * @param
     * @param dataTableRequest
     * @return
     */
    public static DataTablePageCriteria forSortingAndPaging(DataTableRequest dataTableRequest) {

        Integer page = dataTableRequest.getStart() / dataTableRequest.getLength();
        PageRequest pageable = new PageRequest(page, dataTableRequest.getLength());
        int offset = pageable.getPageNumber() * pageable.getPageSize();
        int limit = pageable.getPageSize();

        DataTablePageCriteria dataTablePageCriteria = new DataTablePageCriteria();
        dataTablePageCriteria.setPageSize(limit);
        dataTablePageCriteria.setOffset(offset);
        dataTablePageCriteria.setPageRequest(pageable);

        Integer columnIndex;
        if (!CollectionUtils.isEmpty(dataTableRequest.getOrder())) {
            SortColumnDirection sortColumnDirection = dataTableRequest.getOrder().get(0);
            columnIndex = sortColumnDirection.getColumn();
            dataTablePageCriteria.setAscending(sortColumnDirection.checkAscending());
            dataTablePageCriteria.setOrder(sortColumnDirection.getDir());
            /**
             *  This is unique for stored procedure only. The integer to column mapping is done in the stored procedure.
             *  For all non stored procedure calls we may use the column extraction via integer column
             *  TODO: consider removing extraction, the mapping can be done in the query itself?
             *  That is, 0 = sequenceNumber; 1=clientName and so on
             */
            dataTablePageCriteria.setSortOnColumn(columnIndex);
        }

        dataTablePageCriteria.setUpperRowBound(limit + offset);
        return dataTablePageCriteria;
    }

    /**
     * @param page
     * @return
     */
    public static DataTableResponse extract(Page<?> page) {
        DataTableResponse jsonResponse = new DataTableResponse();
        jsonResponse.setData(page.getContent().toArray());
        jsonResponse.setRecordsTotal(String.valueOf(page.getTotalElements()));
        jsonResponse.setRecordsFiltered(String.valueOf(page.getTotalElements()));

        return jsonResponse;
    }


}


