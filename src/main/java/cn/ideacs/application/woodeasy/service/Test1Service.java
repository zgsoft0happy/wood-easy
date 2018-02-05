package cn.ideacs.application.woodeasy.service;

import cn.ideacs.application.woodeasy.entity.Test1;

import java.util.List;

/**
 * @author yang
 * @date 17-12-19
 */
public interface Test1Service {

    public List<Test1> list();

    public Test1 getById(Long id);

}
