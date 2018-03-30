package cn.ideacs.application.woodeasy.entity.enums;

/**
 * @author yang
 * @date 17-12-19
 */
public enum Gender {
    /**
     * 保密或者未知
     */
    UKNOWN(0, "未知"),
    /**
     * 男
     */
    MALE(1, "男"),
    /**
     * 女
     */
    FEMALE(2,"女");


    private int code;
    private String desc;

    Gender(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDesc(int code) {
        Gender gender = valueOf(code);
        if (gender != null) {
            return gender.getDesc();
        }
        return null;
    }

    public static Gender valueOf(int code) {
        Gender[] genders = Gender.values();
        for (Gender gender : genders) {
            if (code == gender.getCode()) {
                return gender;
            }
        }
        return null;
    }
}
