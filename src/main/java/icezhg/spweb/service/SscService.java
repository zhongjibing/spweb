package icezhg.spweb.service;


import icezhg.spweb.domain.Ssc;

/**
 * Created by zhongjibing on 2017/4/16.
 */
public interface SscService {
    Ssc queryById(int id);

    Ssc findLast();
}
