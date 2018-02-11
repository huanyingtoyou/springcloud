package com.lihy.serviceSecondImpl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author lihy
 * @date 2018/02/11
 */
@RestController
@RequestMapping("/introduce")
public class IntroduceController {

    @RequestMapping(value = "/introduceMe", method = RequestMethod.GET)
    public String introduce(String name) {
        int num = new Random().nextInt(10);
        String introduce = null;
        switch (num) {
            case 0:
                introduce = "大家好，我叫" + name + "，是一名屌丝java攻城狮，老家是河南滴，目前正在研究springcloud的一些用法。";
                break;
            case 1:
                introduce = "大家好，我叫" + name + "，是美美的前端妹子一枚。";
                break;
            case 2:
                introduce = "大家好，我叫" + name + "，是一名剑士，我要仗剑走天涯。";
                break;
            case 3:
                introduce = "大家好，我叫" + name + "，是萌萌哒，要么么。";
                break;
            case 4:
                introduce = "大家好，我叫" + name + "，是一个下水道拳师。";
                break;
            case 5:
                introduce = "大家好，我叫" + name + "，是最最厉害的召唤师，看我大召唤术。";
                break;
            case 6:
                introduce = "大家好，我叫" + name + "，是一只小小小鸟，怎么飞也飞不高！";
                break;
            case 7:
                introduce = "大家好，我叫" + name + "，是一只熊猫，请叫我盼盼，正经脸";
                break;
            case 8:
                introduce = "大家好，我叫" + name + "，是一名枪手，双枪在手，天下我有。";
                break;
            case 9:
                introduce = "大家好，我叫" + name + "，来自火星。";
                break;
            case 10:
                introduce = "大家好，我叫" + name + "，是一名工人，你瞅啥，小心我拿搬砖拍你。";
                break;
        }
        return introduce;
    }
}
