package com.example.aldres.lifeisrpg;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

/**
 * Created by Aldres on 11.04.18.
 */

public class DateTools {

    public String dateToString(long date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return dateFormat.format(date);
    }

    public long getCurrentTimestamp(){
        return (System.currentTimeMillis() / 1000L);
    }

}
