package priv.wmc.study.basic.enums;

/**
 * 简单枚举类
 * @author Wang Mincong
 * @date 2019-07-24 18:24
 */
public enum WeekDayEnum {

    MON("Monday"), TUE("Tuesday"), WED("Wednesday"), THU("Thursday"), FRI("Friday"), SAT("Satday"), SUN("Sunday");
    private final String day;

    WeekDayEnum(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
