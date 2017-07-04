package com.lightside.fg.web.mapper;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author anwar
 */

@Component
public class BigDecimalMapper {
    public String asString(BigDecimal value) {
        if (value != null) {
            DecimalFormat format = new DecimalFormat("###.##");
            format.setRoundingMode(RoundingMode.UNNECESSARY);
            return format.format(value);
        }
        return "";
    }
}
