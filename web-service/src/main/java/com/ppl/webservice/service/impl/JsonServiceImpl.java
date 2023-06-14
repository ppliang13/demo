package com.ppl.webservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ppl.webservice.service.JsonService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by pisiliang on 2023/6/14 14:41
 */
@Service
public class JsonServiceImpl implements JsonService {


    /**
     * json 字符串相减
     * @param json 原json
     * @param subJson 要减去的json
     * @return 相减后的json
     * @throws JsonProcessingException json转换异常
     * 可能有重复的json 不能用set
     */
    @Override
    public String jsonSubJson(String json, String subJson) throws JsonProcessingException {
        //分别排序
        Object jsonO = jsonSort(json);
        Object subJsonO = jsonSort(subJson);

        Set<String> set = new HashSet<>();
        stringToSet(subJsonO, set);
        removeJson(jsonO, set);

        return jsonO.toString();
    }

    private void removeJson(Object o, Set<String> set) {
        if(! (o instanceof String)){
            if(set.contains(o.toString())){
                o = "";
            }
        }
        if (o instanceof List) {
            List list = (List) o;
            for (Object o1 : list) {
                removeJson(o1, set);
            }
        } else if (o instanceof Map) {
            Map map = (Map) o;
            for (Object o1 : map.entrySet()) {
                Map.Entry entry = (Map.Entry) o1;
                removeJson(entry.getValue(), set);
            }
        }
    }



    private void stringToSet(Object o, Set<String> set) {
        if(! (o instanceof String)){
            set.add(o.toString());
        }
        if (o instanceof List) {
            List list = (List) o;
            for (Object o1 : list) {
                stringToSet(o1, set);
            }
        } else if (o instanceof Map) {
            Map map = (Map) o;
            for (Object o1 : map.entrySet()) {
                Map.Entry entry = (Map.Entry) o1;
                stringToSet(entry.getValue(), set);
            }
        }
    }

        @Override
        public Object jsonSort (String json) throws JsonProcessingException {
            //将json转为list 对象
            ObjectMapper mapper = new ObjectMapper();
            List list = mapper.readValue(json, List.class);
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            if (!list.isEmpty()) {
                for (Object o : list) {
                    LinkedHashMap map = (LinkedHashMap) o;
                    sortHashMapByKey(map);
                    //遍历map
                    for (Object o1 : map.entrySet()) {
                        HashMap.Entry entry = (HashMap.Entry) o1;
                        if (entry.getValue().toString().endsWith("}") || entry.getValue().toString().endsWith("]")) {
                            String s1 = writer.writeValueAsString(entry.getValue());
                            entry.setValue(jsonSort(s1));
                        }
                    }
                }

                list.sort((o1, o2) -> {
                    String s1 = o1.toString();
                    String s2 = o2.toString();
                    return s1.compareTo(s2);
                });
            }
            return list;
        }
        /**
         * 对map进行排序
         * @param map map
         */
        private void sortHashMapByKey (LinkedHashMap map){
            if (map.isEmpty()) {
                return;
            }
            List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());

            Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });

            for (int i = 0; i < list.size(); i++) {
                Map.Entry<String, String> entry = list.get(i);
                map.remove(entry.getKey());
                map.put(entry.getKey(), entry.getValue());
            }

        }


        public static void main (String[]args) throws JsonProcessingException {
            String json = "[\n" +
                    "    {\n" +
                    "        \"targetRoute\": \"ymzc\",\n" +
                    "        \"targetCode\": \"JS4212020000001100219\",\n" +
                    "        \"toCode\": \"4212002023440200007\",\n" +
                    "        \"toRoute\": \"ymzc\",\n" +
                    "        \"list\": [\n" +
                    "            {\n" +
                    "                \"targetRoute\": \"ymzc\",\n" +
                    "                \"targetCode\": \"JS4212020000001100219\",\n" +
                    "                \"toCode\": \"4212002023440200007\",\n" +
                    "                \"toRoute\": \"ymzc\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"targetRoute\": \"checkCode\",\n" +
                    "                \"targetCode\": \"JS4212020000001100221\",\n" +
                    "                \"toCode\": \"4212002023411000040\",\n" +
                    "                \"toRoute\": \"ymzc\"\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"targetRoute\": \"checkCode\",\n" +
                    "        \"targetCode\": \"JS4212020000001100221\",\n" +
                    "        \"toCode\": \"4212002023411000040\",\n" +
                    "        \"toRoute\": \"ymzc\",\n" +
                    "        \"list\": [\n" +
                    "            {\n" +
                    "                \"targetRoute\": \"ymzc\",\n" +
                    "                \"targetCode\": \"JS4212020000001100219\",\n" +
                    "                \"toCode\": \"4212002023440200007\",\n" +
                    "                \"toRoute\": \"ymzc\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"targetRoute\": \"checkCode\",\n" +
                    "                \"targetCode\": \"JS4212020000001100221\",\n" +
                    "                \"toCode\": \"4212002023411000040\",\n" +
                    "                \"toRoute\": \"ymzc\"\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    }\n" +
                    "]\n";
            JsonServiceImpl jsonService = new JsonServiceImpl();
            String s = jsonService.jsonSubJson(json, json);
            System.out.println("s = " + s);
        }

    }
