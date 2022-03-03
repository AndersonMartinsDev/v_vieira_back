package com.vvieira.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Service
@Scope("singleton")
public final class DataUtilService {

    public String formatDataBr(LocalDate localDate){
        return DateTimeFormatter.ofPattern("dd/MM/yyyy",new Locale("pt-br")).format(localDate);
    }
    public String formatDateTimeBr(LocalDateTime localDate){
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm",new Locale("pt-br")).format(localDate);
    }

    public Date calcExpirationToken(String expiration){
        return new Date(new Date().getTime() + Long.parseLong(expiration));
    }

    public String expirationTimeTokenFormat(String expiration){
        return formatDateTimeBr(calcExpirationToken(expiration).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    }
}
