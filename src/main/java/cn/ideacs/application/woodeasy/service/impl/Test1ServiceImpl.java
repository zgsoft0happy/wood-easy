package cn.ideacs.application.woodeasy.service.impl;

import cn.ideacs.application.woodeasy.dao.Test1Mapper;
import cn.ideacs.application.woodeasy.entity.Test1;
import cn.ideacs.application.woodeasy.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yang
 * @date 17-12-19
 */
@Service
public class Test1ServiceImpl implements Test1Service{

    @Autowired
    private Test1Mapper test1Mapper;

    @Override
    public List<Test1> list() {
        return test1Mapper.list();
    }

    @Override
    public Test1 getById(Long id) {
        return test1Mapper.getById(id);
    }
}
