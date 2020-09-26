package priv.wmc.study.basic.enums;

/**
 * @author Wang Mincong
 * @date 2020-07-31 23:36:49
 */
public enum AnimalEnum {

    CAT("1", "猫"),
    DOG("2", "狗");

    private final String id;
    private final String desc;

    AnimalEnum(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static AnimalEnum getById(String id) {
        for (AnimalEnum animal : AnimalEnum.values()) {
            if (id.equals(animal.getId())) {
                return animal;
            }
        }
        return null;
    }

    public String getId() {
		return this.id;
	}

    public String getDesc() {
		return this.desc;
	}

}
