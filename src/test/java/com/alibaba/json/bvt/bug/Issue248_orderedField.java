package com.alibaba.json.bvt.bug;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

public class Issue248_orderedField extends TestCase {

    public void test_0() throws Exception {
        String text = "{\"b\":\"b\",\"d\":\"d\",\"c\":\"c\",\"a\":\"a\"}";
        JSONObject object = JSON.parseObject(text, Feature.OrderedField);
        System.out.println(object);

        Assert.assertEquals("b", object.keySet().toArray()[0]);
        Assert.assertEquals("d", object.keySet().toArray()[1]);
        Assert.assertEquals("c", object.keySet().toArray()[2]);
        Assert.assertEquals("a", object.keySet().toArray()[3]);
    }

    public void test_1() throws Exception {
        String text = "{\"a\":\"a\",\"b\":\"b\",\"c\":\"c\",\"d\":\"d\"}";
        System.out.println(JSON.parseObject(text));

        JSONObject object = JSON.parseObject(text, Feature.OrderedField);
        System.out.println(object);

        Assert.assertEquals("a", object.keySet().toArray()[0]);
        Assert.assertEquals("b", object.keySet().toArray()[1]);
        Assert.assertEquals("c", object.keySet().toArray()[2]);
        Assert.assertEquals("d", object.keySet().toArray()[3]);

    }

}
