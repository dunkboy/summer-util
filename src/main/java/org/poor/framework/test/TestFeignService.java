package org.poor.framework.test;

import feign.Headers;
import feign.RequestLine;
import org.poor.framework.test.domain.po.Student;


/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: FeignPartyBService</p>
 * <p>Description: FeignPartyBService</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/9 16:44</p>
 *
 * @author cb
 * @version 1.0
 **/
public interface TestFeignService
{

    @RequestLine("POST " + "/test/bbb")
    @Headers("Content-Type: application/json")
    Student callTest(Student student);
}
