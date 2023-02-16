package com.cmrhyq.utils.date;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <h1 style="color:white">
 * 时间计算工具类
 * </h1>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project CommonUtilsPackage
 * @docRoot com.cmrhyq.utils.date
 * @date 2023-02-16 0:27
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Slf4j
public class DateCalculation {

    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 获取SimpleDateFormat
     *
     * @return SimpleDateFormat - yyyy-MM-dd
     */
    private static SimpleDateFormat getSimpleDate() {
        try {
            SimpleDateFormat sdf = THREAD_LOCAL.get();
            if (sdf == null) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                THREAD_LOCAL.set(sdf);
            }
            return sdf;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        } finally {
            THREAD_LOCAL.remove();
        }
    }

    /**
     * 计算两个日期之间的差
     *
     * @param endDate   结束日期
     * @param startDate 开始的日期
     * @return long
     */
    public static long getDatePoor(Date endDate, Date startDate) {
        long nd = 1000 * 24 * 60 * 60;
//        long nh = 1000 * 60 * 60;
//        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
//        long hour = diff % nd / nh;
        // 计算差多少分钟
//        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day;
    }

    /**
     * 计算以前的日期到现在过去了多少天
     *
     * @param date 以前的日期 - yyyy-MM-dd
     * @return long
     */
    public static long calculationPastDay(String date) {
        SimpleDateFormat simpleDateFormat = getSimpleDate();
        Date startDate = new Date();
        try {
            assert simpleDateFormat != null;
            startDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getDatePoor(new Date(), startDate);
    }

    /**
     * 计算生日
     * @param date 生日 - yyyy-MM-dd
     * @return long
     */
    public static long calculationBirthday(String date){
        SimpleDateFormat simpleDateFormat = getSimpleDate();
        Calendar cToday = Calendar.getInstance();
        Calendar cBirth = Calendar.getInstance();
        Date now = new Date();
        try {
            assert simpleDateFormat != null;
            now = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cBirth.setTime(now);
        cBirth.set(Calendar.YEAR, cToday.get(Calendar.YEAR));
        int days;
        if (cBirth.get(Calendar.DAY_OF_YEAR) < cToday.get(Calendar.DAY_OF_YEAR)) {
            days = cToday.getActualMaximum(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
            days += cBirth.get(Calendar.DAY_OF_YEAR);
        } else {
            days = cBirth.get(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
        }
        return days;
    }
}
