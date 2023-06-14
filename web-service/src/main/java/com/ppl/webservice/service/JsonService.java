package com.ppl.webservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by pisiliang on 2023/6/14 14:40
 */

public interface JsonService {


    String jsonSubJson(String json, String subJson) throws JsonProcessingException;

    /**
     * json排序
     * @param json json字符串
     * @return 排序后的json字符串
     * @throws JsonProcessingException json转换异常
     */
    Object jsonSort(String json) throws JsonProcessingException;

}
