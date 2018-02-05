package cn.ideacs.application.woodeasy.dao;

import cn.ideacs.application.woodeasy.entity.Test1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yang
 * @date 17-12-19
 */
public interface Test1Mapper {

    public List<Test1> list();

    public Test1 getById(@Param("id") Long id);

}
