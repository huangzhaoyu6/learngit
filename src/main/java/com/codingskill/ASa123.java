package com.codingskill;

import com.alibaba.fastjson.JSON;

/**
 * @author huangzhaoyu
 * @date 2020/2/21 15:56
 */
public class ASa123 {

    public static void main(String[] args) {

        String str =    "{\n" +
                "            \"type\":\"偏离\";\n" +
                "            \"vnoa\":\"123\"\n" +
                "        }";

        WarnInfo warnInfo = JSON.parseObject(str, WarnInfo.class);
        System.out.println(warnInfo);
    }

}
