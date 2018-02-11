package com.lihy.testWeb.controller;

import com.lihy.feign.api.test.IntroduceApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihy
 * @date 2018/02/11
 */
@RestController
@RequestMapping("/introduce")
@Api(value = "introduce", description = "介绍", produces = MediaType.APPLICATION_JSON_VALUE)
public class IntroduceController {

    @Autowired
    public IntroduceApi introduceApi;

    @ApiOperation(value = "自我介绍", notes = "快来告诉我你是谁，否则我就嘤嘤嘤")
    @RequestMapping(value = "/introduceMe", method = RequestMethod.GET)
    public String introduce(String name){
        return introduceApi.introduce(name);
    }
}
