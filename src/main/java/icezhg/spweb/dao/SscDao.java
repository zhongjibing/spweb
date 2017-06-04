package icezhg.spweb.dao;


import icezhg.spweb.domain.Ssc;

/**
 * Created by zhongjibing on 2017/4/16.
 */
public interface SscDao {
    Ssc queryById(int id);

    Ssc findLast();
}
