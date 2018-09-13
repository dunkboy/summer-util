package org.poor.framework;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.poor.framework.test.TestCsv;
import org.poor.framework.utils.csv.CsvUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: ExampleTest</p>
 * <p>Description: ExampleTest</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/8/9 10:16</p>
 * @author cb
 * @version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChenTest
{


    @Test
    public void test() throws Exception
    {

    }

    public static void main(String[] args) throws Exception
    {
//        Map<String, String> values = new CSVReaderHeaderAware(new FileReader("F:\\workspace_idea_remark\\summer-util\\src\\test\\resources\\test.csv")).readMap();
//        values.forEach((k,v)->{
//            System.out.println(k+"="+v);
//        });
//        Map<String, String> values = CsvUtil.parseCsvOneLine("F:\\workspace_idea_remark\\summer-util\\src\\test\\resources\\test.csv");
//        values.forEach((k,v)->{
//            System.out.println(k+"="+v);
//        });

        List<TestCsv> beans = CsvUtil.parseCsv("F:\\workspace_idea_remark\\summer-util\\src\\test\\resources\\test.csv", TestCsv.class, null);
//        beans.stream().forEach(item->{
//            System.out.print(item.getHeader1());
//            System.out.print(item.getHeader2());
//            System.out.print(item.getHeader3());
//            System.out.print(item.getHeader4());
//            System.out.println("----");
//        });
        CsvUtil.generateCsvFromBean(beans, "F:\\workspace_idea_remark\\summer-util\\src\\test\\resources\\1234.csv");
    }

}
