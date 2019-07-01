package com.eLibraryClient.applicationWebClientbusiness.contract;

import com.eLibraryClient.applicationWebClientbusiness.Enums.CompareDate;
import org.springframework.stereotype.Service;

@Service
public interface DateManager {
    String todayDate();
    String addDaysOnTodayDate(int pNbrOfDay);
    Enum<CompareDate> compareDateWithToday(String pDate);
}