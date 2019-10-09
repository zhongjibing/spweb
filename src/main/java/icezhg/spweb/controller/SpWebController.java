package icezhg.spweb.controller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;

import icezhg.spweb.domain.Ssc;
import icezhg.spweb.service.SscService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhongjibing on 2017/4/25.
 */
@RestController
@RequestMapping({"/web", "/test"})
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

    private ThreadPoolExecutor threadPoolExecutor;
    {
        threadPoolExecutor = new ThreadPoolExecutor(3,3,300L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
    }

    @RequestMapping("/hello")
    public Object hello() throws InterruptedException {
        LOGGER.info("hello, world");
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("this is a test");
                latch.countDown();
            }
        }).start();
        latch.await();
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("hehe hehe hehe");
            }
        });
        return "hello world!";
    }

    @Autowired
    RestTemplate template;

    @RequestMapping("/")
    public ResponseEntity<String> callBackend() {
        String result = template.getForObject("http://localhost:9000/api", String.class);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
