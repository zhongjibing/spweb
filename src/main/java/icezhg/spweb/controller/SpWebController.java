package icezhg.spweb.controller;

import javax.annotation.Resource;

import icezhg.spweb.domain.Ssc;
import icezhg.spweb.service.SscService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhongjibing on 2017/4/25.
 */
@Controller
@RequestMapping("/web")
public class SpWebController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpWebController.class);

    @Resource
    private SscService sscService;

    @ResponseBody
    @RequestMapping(value = "/queryById")
    public Ssc queryById(int id) {
        LOGGER.info("[SpWebController.queryById] id={}", id);
        return sscService.queryById(id);
    }
}
