package org.poor.framework;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.github.drinkjava2.jsqlbox.SqlBoxContext;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.poor.framework.test.B;
import org.poor.framework.test.TestCsv;
import org.poor.framework.test.dao.StudentDao;
import org.poor.framework.test.datasource.DataSourceSupport;
import org.poor.framework.test.domain.po.Student;
import org.poor.framework.test.enums.AssignTypeEnum;
import org.poor.framework.utils.annotation.Column;
import org.poor.framework.utils.annotation.DataSource;
import org.poor.framework.utils.csv.CsvUtil;
import org.poor.framework.utils.email.EmailUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.lang.System.setOut;

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
    @Resource
    private StudentDao studentDao;

    @Resource
    private SqlBoxContext sqlBoxContext;

    @Test
    @DataSource("mysql8012DataSource")
    public void test() throws Exception
    {
        Student s = new Student();
        s.setName("而发热王若飞");
        s.setTenantId(54L);
        s.setAssignType(AssignTypeEnum.HAVE_ASSIGN);
//        sqlBoxContext.eInsert(s);
        sqlBoxContext.nExecute("INSERT INTO `test`.`cb_student`( `tenant_id`, `del_flag`, `name`, `assign_type`) VALUES ( 333, 0, 'ggd烦烦烦', 888)");

//        List<MyUser> beans = CsvUtil.parseCsv("F:\\workspace_idea_remark\\summer-util\\src\\test\\resources\\aaa.csv", MyUser.class, null);
//        beans.stream().forEach(item->{
//            item.setId(item.getId()+34);
//        });
//        myUserMapper.insertList(beans);
//        EmailUtil.sendMail("369082670@qq.com","爸爸来啦","叫霸霸~~~~~~~~");
//        for (int i = 0; i < 10; i++)
//        {
//            Student s = new Student();
//            s.setName("name"+i);
////            s.setTenantId((long)i);
//            s.setAssignType(AssignTypeEnum.NOT_ASSIGN);
//            studentDao.insert(s);
//        }
//        List<Student> students = studentDao.selectList(new QueryWrapper<>());
//        students.stream().parallel().forEach(System.out::println);
//        System.out.println(AssignTypeEnum.NOT_ASSIGN.toString());;
    }

    @DataSource(value = "mysql5717DataSource")
    @Test
    public void test2() throws Exception
    {
        System.out.println("============={}" + DataSourceSupport.get());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            Student s = new Student();
            s.setName("######");
//            s.setTenantId((long) i);
            s.setAssignType(AssignTypeEnum.HAVE_ASSIGN);
//        studentDao.insert(s);
//            studentDao.batchInsert(s);
            students.add(s);
        }
//        studentDao.batchInsert(students);d
    }

    public static void main(String[] args) throws Exception
    {


//        int i = 10 ^ 20 ;
//        System.out.println(i);
//        int b = 20 ^ 20 ^10;
//        System.out.println(b);

//        StringBuilder sb = new StringBuilder("<foreach");
//        sb.append(StringPool.COMMA).append(StringPool.NEWLINE);
//        System.out.println(sb.toString());
//        System.out.println(sb.lastIndexOf(","));
//        sb.delete(sb.lastIndexOf(","), sb.length());
//        System.out.println(sb.toString());
//        Student s = new Student();
//        s.setName("qwer");
//        s.setAssignType(AssignTypeEnum.HAVE_ASSIGN);
//        Class<? extends Student> aClass = s.getClass();
//        Field[] declaredFields = aClass.getDeclaredFields();
//        List<Field> collect = Arrays.stream(declaredFields).collect(Collectors.toList());
//        collect.stream().forEach(item -> {
//            System.out.print(item.getName() + "===");
//            Column column = item.getAnnotation(Column.class);
//            if (column != null)
//            {
//                System.out.print(column.batchInsert());
//            }
//            System.out.println();
//        });
//        Map<String, String> values = new CSVReaderHeaderAware(new FileReader("F:\\workspace_idea_remark\\summer-util\\src\\test\\resources\\test.csv")).readMap();
//        values.forEach((k,v)->{
//            System.out.println(k+"="+v);
//        });
//        Map<String, String> values = CsvUtil.parseCsvOneLine("F:\\workspace_idea_remark\\summer-util\\src\\test\\resources\\test.csv");
//        values.forEach((k,v)->{
//            System.out.println(k+"="+v);
//        });

//        List<TestCsv> beans = CsvUtil.parseCsv("F:\\workspace_idea_remark\\summer-util\\src\\test\\resources\\test.csv", TestCsv.class, null);
//        beans.stream().forEach(item->{
//            System.out.print(item.getHeader1());
//            System.out.print(item.getHeader2());
//            System.out.print(item.getHeader3());
//            System.out.print(item.getHeader4());
//            System.out.println("----");
//        });
//        CsvUtil.generateCsvFromBean(beans, "F:\\workspace_idea_remark\\summer-util\\src\\test\\resources\\1234.csv");
    }

}
