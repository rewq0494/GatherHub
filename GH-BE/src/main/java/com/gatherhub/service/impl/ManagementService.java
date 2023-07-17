package com.gatherhub.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gatherhub.dao.ContractDao;
import com.gatherhub.dao.MeetingRoomOrderDao;
import com.gatherhub.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

@Service
public class ManagementService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private MeetingRoomOrderDao meetingRoomOrderDao;

    @Autowired
    private MemberDao memberDao;

    // 全部數據
    public List<List<? extends Number>> getAllChartData(){
        List<List<? extends Number>> data = new ArrayList<>();

        List<Integer> officeUsage = getOfficeUsageDataAsList();
        List<Integer> meetingRoomUsage = getMeetingRoomUsageDataAsList();
        List<Double> officeRent = getcalculateUsageDataAsList();
        List<Double> meetingRoomRent = getMeetingRoomMonthRentAsList();

        List<Double> totalRent = new ArrayList<>();
        for (int i = 0; i < officeRent.size(); i++) {
            double sum = officeRent.get(i) + meetingRoomRent.get(i);
            totalRent.add(sum);
        }

        data.add(officeUsage);
        data.add(meetingRoomUsage);
        data.add(officeRent);
        data.add(meetingRoomRent);
        data.add(totalRent);

        return data;
    }

    // 折線圖數據
    public List<List<? extends Number>> getLineChartData(){
        List<List<? extends Number>> data = new ArrayList<>();

        List<Integer> officeUsage = getOfficeUsageDataAsList();
        List<Integer> meetingRoomUsage = getMeetingRoomUsageDataAsList();
        List<Double> officeRent = getcalculateUsageDataAsList();
        List<Double> meetingRoomRent = getMeetingRoomMonthRentAsList();


        // office + mR 的總收入
        List<Double> totalRent = new ArrayList<>();
        for (int i = 0; i < officeRent.size(); i++) {
            double sum = officeRent.get(i) + meetingRoomRent.get(i);
            totalRent.add(sum);
        }

        // office 使用率
        List<Double> adjustedOfficeUsage = new ArrayList<>();
        for (Integer usage : officeUsage) {
            double adjustedValue = (usage / 53.0)*100;  // 將 officeUsage 的值除以 50
            adjustedValue = Math.round(adjustedValue * 10.0) / 10.0; // 取到小數點後一位
            adjustedOfficeUsage.add(adjustedValue);
        }

        // MR 使用率
        List<Double> adjustedMeetingRoomUsage = new ArrayList<>();
        for (Integer usage : meetingRoomUsage) {
            double adjustedValue = (usage / 450.0)*100;  // 將 officeUsage 的值除以 50
            adjustedValue = Math.round(adjustedValue * 10.0) / 10.0; // 取到小數點後一位
            adjustedMeetingRoomUsage.add(adjustedValue);
        }

        data.add(adjustedOfficeUsage);
        data.add(adjustedMeetingRoomUsage);
        data.add(totalRent);


        return data;
    }

    // 圓餅圖數據
    public List<Double> getBarChartData(){
        List<Double> data = new ArrayList<>();

        List<Double> officeRent = getcalculateUsageDataAsList();
        List<Double> meetingRoomRent = getMeetingRoomMonthRentAsList();

        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();

        double sum = 0;
        // totalYearRent
        for (int i = 11; i > (11-currentMonth); i--) {
            sum += (officeRent.get(i) + meetingRoomRent.get(i));
        }
        data.add(sum);

        // officeYearRent
        double officeYearRent = 0;
        for (int i = 11; i > (11-currentMonth); i--){
            officeYearRent += officeRent.get(i);
        }

        // MRYearRent
        double MRYearRent = 0;
        for (int i = 11; i > (11-currentMonth); i--){
            MRYearRent += meetingRoomRent.get(i);
        }

        data.add(officeYearRent);
        data.add(MRYearRent);

        return data;
    }

    // 上面四格數據
    public List<Double> getSomeData(){
        List<Double> data = new ArrayList<>();

        Double totalMember = memberDao.getTotalMember();

        List<Double> officeRent = getcalculateUsageDataAsList();
        List<Double> meetingRoomRent = getMeetingRoomMonthRentAsList();

        List<List<? extends Number>> usageData = getLineChartData();

        // 本月總租金
        double thisMonthTotalRent = officeRent.get(11) + meetingRoomRent.get(11);

        // 本月 office 使用率
        double officeThisMonthUsage = (double) usageData.get(0).get(11);

        // 本月 MR 使用率
        double meetingRoomThisMonthUsage = (double) usageData.get(1).get(11);



        data.add(thisMonthTotalRent);
        data.add(officeThisMonthUsage);
        data.add(meetingRoomThisMonthUsage);
        data.add(totalMember);

        return data;
    }


    // 計算辦公室每月出租數量並從 Map 轉成 List
    public List<Integer> getOfficeUsageDataAsList() {
        List<Object[]> officeUsageData = contractDao.getOfficeUsageData();
        Map<String, Integer> officeMonthlyUsage = calculateOfficeMonthlyUsage(officeUsageData);

        List<Integer> officeMonthlyUsageList = new ArrayList<>();
        for (Integer usage : officeMonthlyUsage.values()) {
            officeMonthlyUsageList .add(usage);
        }

        return officeMonthlyUsageList ;
    }

    // 計算會議室的出租數量
    public List<Integer> getMeetingRoomUsageDataAsList() {

        List<Integer> meetingMonthlyUsageList = new ArrayList<>();

        List<Integer> testNumbers = Arrays.asList(273, 187, 115, 249, 92, 207, 142, 68, 156, 218, 289, 76);
        meetingMonthlyUsageList.addAll(testNumbers);

        return meetingMonthlyUsageList;
    }

    // 計算辦公室每月租金並從 Map 轉成 List
    public List<Double> getcalculateUsageDataAsList() {
        List<Object[]> officeRentData = contractDao.getContractDateWithRent();
        Map<String, Double> monthlyUsage = calculateOfficeMonthlyRent(officeRentData);

        List<Double>officeRentList = new ArrayList<>();
        for (Double usage : monthlyUsage.values()) {
            officeRentList.add(usage);
        }

        return officeRentList;
    }

    // 計算 MR 的月總租金
    public List<Double> getMeetingRoomMonthRentAsList(){
        List<Object[]> meetingRoomRentData = meetingRoomOrderDao.getMeetingRoomMonthRent();

        LocalDate currentDate = LocalDate.now();

        List<Double> meetingRoomRentList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            meetingRoomRentList.add(0.0);
        }

        for (Object[] data : meetingRoomRentData) {
            java.sql.Timestamp rentTimestamp = (java.sql.Timestamp) data[0];
            LocalDate localDate = rentTimestamp.toLocalDateTime().toLocalDate();
            Double value = (Double) data[1];

            // 判斷日期是否在最近12个月内
            if (localDate.isAfter(currentDate.minusMonths(11).withDayOfMonth(1)) && localDate.isBefore(currentDate.plusDays(1))) {
                int index = currentDate.getMonthValue() - localDate.getMonthValue();
                if (value == null) {
                    value = 0.0;
                }
                meetingRoomRentList.set(index, value);
            }
        }
        Collections.reverse(meetingRoomRentList);
        return meetingRoomRentList;

    }



    // 計算辦公室每月租金
    public Map<String, Double> calculateOfficeMonthlyRent(List<Object[]> officeRentData) {
        Map<String, Double> officeMonthlyRent = new TreeMap<>();

        for (Object[] data : officeRentData) {
            LocalDate startDate = (LocalDate) data[0];
            LocalDate endDate = (LocalDate) data[1];
            double rent = (double) data[2];

            // 計算最近十二個的月份
            List<LocalDate> last12Months = getLast12Months(startDate, endDate);
            LocalDate startDateInRange = last12Months.get(0);
            LocalDate endDateInRange = last12Months.get(1);

            // 判斷月份是否在指定的範圍
            if (!startDateInRange.isAfter(endDateInRange)) {
                // 計算每個月的租金总和
                YearMonth startYearMonth = YearMonth.from(startDateInRange);
                YearMonth endYearMonth = YearMonth.from(endDateInRange);
                while (!startYearMonth.isAfter(endYearMonth)) {
                    String monthKey = startYearMonth.toString();
                    officeMonthlyRent.put(monthKey, officeMonthlyRent.getOrDefault(monthKey, 0.0) + rent);
                    startYearMonth = startYearMonth.plusMonths(1);
                }
            }
        }
        return officeMonthlyRent;
    }


    // 計算辦公室每月出租數量
    public Map<String, Integer> calculateOfficeMonthlyUsage(List<Object[]> officeUsageData) {
        Map<String, Integer> officeMonthlyUsage = new TreeMap<>();

        for (Object[] data : officeUsageData) {
            LocalDate startDate = (LocalDate) data[1];
            LocalDate endDate = (LocalDate) data[2];

            // 計算最近十二個的月份
            List<LocalDate> last12Months = getLast12Months(startDate, endDate);
            LocalDate startDateInRange = last12Months.get(0);
            LocalDate endDateInRange = last12Months.get(1);

            // 判斷月份是否在指定的範圍
            if (!startDateInRange.isAfter(endDateInRange)) {
                // 計算每個月的使用次數
                YearMonth startYearMonth = YearMonth.from(startDateInRange);
                YearMonth endYearMonth = YearMonth.from(endDateInRange);
                while (!startYearMonth.isAfter(endYearMonth)) {
                    String monthKey = startYearMonth.toString();
                    officeMonthlyUsage.put(monthKey, officeMonthlyUsage.getOrDefault(monthKey, 0) + 1);
                    startYearMonth = startYearMonth.plusMonths(1);
                }
            }
        }
        return officeMonthlyUsage;
    }


    // 計算最近十二個的月份
    public List<LocalDate> getLast12Months(LocalDate startDate, LocalDate endDate){

        // 目前日期
        LocalDate currentDate = LocalDate.now();

        LocalDate startDateInRange = startDate.isBefore(currentDate.minusMonths(11)) ? currentDate.minusMonths(11) : startDate;
        LocalDate endDateInRange = endDate.isAfter(currentDate) ? currentDate : endDate;

        List<LocalDate> DateInRange = new ArrayList<>();

        DateInRange.add(startDateInRange);
        DateInRange.add(endDateInRange);

        return DateInRange;
    }



}
