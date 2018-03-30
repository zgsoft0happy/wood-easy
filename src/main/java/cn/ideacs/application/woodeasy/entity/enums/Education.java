package cn.ideacs.application.woodeasy.entity.enums;

/**
 * @author yang
 * @date 17-12-19
 */
public enum  Education {
    /**
     * 文盲
     */
    ILLITERACY(0, "文盲"),
    /**
     * 小学
     */
    GRADESCHOOL(1, "小学"),
    /**
     * 初中
     */
    MIDDLESCHOOL(2, "初中"),
    /**
     * 高中
     */
    HIGHSCHOOL(3, "高中"),
    /**
     * 本科
     */
    REGULARCOLLEGE(4,"本科"),
    /**
     * 硕士
     */
    MASTER(5, "硕士"),
    /**
     * 博士
     */
    DOCTOR(6, "博士"),
    /**
     * 专科
     */
    PROFESSIONALCOLLEGE(7, "专科"),
    /**
     * 中专
     */
    SPECAILSCHOOL(8, "中专"),
    /**
     * 大专
     */
    JUNIORCOLLEGE(9, "大专"),
    /**
     * 其他
     */
    OTHER(10, "其他");
    /**
     * 编码
     */
    private int type;
    /**
     * 类型的名称
     */
    private String typeName;

    Education(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    /**
     * 获得学历类型对应的code
     * @return
     */
    public int getType() {
        return type;
    }

    /**
     * 获得学历类型的中文描述
     * @return
     */
    public String getTypeName() {
        return typeName;
    }

    public static String getTypeName(int type) {
        Education education = valueOf(type);
        if (education != null) {
            return education.getTypeName();
        }
        return null;
    }

    /**
     * 根据学历的code码获得对应的学历枚举类型
     * @param code
     * @return
     */
    public static Education valueOf(int code) {
        Education[] educations = Education.values();
        for (Education education : educations) {
            if (code == education.getType()) {
                return education;
            }
        }
        return null;
    }
}
