package com.lightside.fg.web.mapper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author anwar
 */

public class DateMapper {

    public String asString(Date date) {
        return date != null ? new SimpleDateFormat("dd-MM-yyyy")
                .format(date) : null;
    }

    public String asString(Timestamp date) {
        return date != null ? new SimpleDateFormat("dd-MM-yyyy")
                .format(date) : null;
    }
}
