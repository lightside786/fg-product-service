package com.lightside.fg.web.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author anwar
 */

@Component
public class DateMapper {

    public String asString(Date date) {
        return date != null ? new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
                .format(date) : null;
    }

    public String asString(Timestamp date) {
        return date != null ? new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z")
                .format(date) : null;
    }
}
