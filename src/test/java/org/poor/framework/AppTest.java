package org.poor.framework;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import org.junit.Test;
import org.poor.framework.TestController.A;
import org.poor.framework.json.FastJsonUtil;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue(true);
    }

    public static void main(String[] args)
    {
//        String test = "fkdsfkdsj${key1}fdfdsfdsfds${key2}";
//        String newtest= StringUtils.replaceEval(test, new IStringReplaceProcess()
//        {
//            @Override
//            public String doReplace(String key, StringBuffer src, int prefixIndex, int suffixIndex)
//            {
//
//                if (key.equalsIgnoreCase("key1")){
//                    return "@@@@";
//
//                }else if (key.equalsIgnoreCase("key2")){
//                    return "######";
//
//                }
//                return null;
//            }
//        });
//        System.out.println(test);
//        System.out.println(newtest);
        PropertyPreFilter filter = new PropertyPreFilter()
        {
            @Override
            public boolean apply(JSONSerializer jsonSerializer, Object o, String s)
            {
                return false;
            }
        };
        A a = new A();
        a.setAge(12);
        a.setName("sadasd");
        System.out.println(FastJsonUtil.toJSONString(a));
        String aa="{\"age\":12,\"name\":\"dads\"}";
//        String aa="{\"age\":12}";
        A parse = FastJsonUtil.parseObject(aa,A.class);
        System.out.println(parse.getName());
    }
}
