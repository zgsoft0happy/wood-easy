package cn.ideacs.application.woodeasy.entity.vos;

/**
 * @author yang
 * @date 17-12-19
 */
public class AccountVo {

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户登录名
     */
    private String username;
    /**
     * 用户昵称
     */
    private String showName;
    /**
     * 用户真实姓名
     */
    private String realName;
    /**
     * 用户电话
     */
    private String phone;
    /**
     * 用户qq
     */
    private String qq;
    /**
     * 用户微信
     */
    private String wechat;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户学历
     */
    private String education;
    /**
     * 用户年龄
     */
    private Integer age;
    /**
     * 用户性别
     */
    private String gender;
    /**
     * 是否无效
     */
    private Integer isDelete;
    /**
     * 备注
     */
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountVo{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", showName='").append(showName).append('\'');
        sb.append(", realName='").append(realName).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", qq='").append(qq).append('\'');
        sb.append(", wechat='").append(wechat).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", education='").append(education).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", isDelete=").append(isDelete);
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
