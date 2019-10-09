package icezhg.spweb.service.impl;

import javax.annotation.Resource;


import icezhg.spweb.dao.SscDao;
import icezhg.spweb.domain.Ssc;
import icezhg.spweb.service.SscService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by zhongjibing on 2017/4/16.
 */
@Service
public class SscServiceImpl implements SscService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SscServiceImpl.class);

//    @Resource
    private SscDao sscDao;

    @Override
    public Ssc queryById(int id) {
        return sscDao.queryById(id);
    }

    @Override
    public Ssc findLast() {
        return sscDao.findLast();
    }
}
