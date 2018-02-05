package cn.ideacs.application.woodeasy.entity;

/**
 * @author yang
 * @date 17-12-19
 */
public class Test1 {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
