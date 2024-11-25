package coid.bcaf.bebootcamp.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;
import java.util.*;

@Repository
public class IDaoImpl{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private StringBuilder sBuild;


    public List<Map<String,Object>> getAll(String query) {
        if(sBuild==null){
            sBuild = new StringBuilder();
        }
        sBuild.setLength(0);
        sBuild.append(query);

        return jdbcTemplate.queryForList(sBuild.toString());
    }
}