package com.zou.druid;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.zou.mqconfig.DataSourceContextHolder;

public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
