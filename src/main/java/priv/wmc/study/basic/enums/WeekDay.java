package priv.wmc.study.basic.enums;

/**
 * 简单枚举类
 * @author 王敏聪
 * @date 2019-07-24 18:24
 */
public enum WeekDay {

    MON("Monday"), TUE("Tuesday"), WED("Wednesday"), THU("Thursday"), FRI("Friday"), SAT("Satday"), SUN("Sunday");
    private final String day;

    WeekDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
