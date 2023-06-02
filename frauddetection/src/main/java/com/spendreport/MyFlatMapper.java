package com.spendreport;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * Created by pisiliang on 2023/6/1 14:08
 */
public class MyFlatMapper implements FlatMapFunction<String, Tuple2<String, Integer>> {

    @Override
    public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
        // 按照空格分词
        String[] words = s.split(" ");
        // 遍历所有word，包成二元组输出
        for (String word : words) {
            collector.collect(new Tuple2<>(word, 1));
        }
    }
}
