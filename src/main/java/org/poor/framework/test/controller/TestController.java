package org.poor.framework.test.controller;/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: TestController</p>
 * <p>Description: TestController</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/8/31 23:31</p>
 * @author cb
 * @version 1.0
 **/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.poor.framework.test.A;
import org.poor.framework.test.dao.StudentDao;
import org.poor.framework.test.datasource.DataSourceSupport;
import org.poor.framework.test.domain.po.Student;
import org.poor.framework.test.enums.AssignTypeEnum;
import org.poor.framework.test.service.StudentService;
import org.poor.framework.utils.annotation.DataSource;
import org.poor.framework.utils.json.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *      _mZ***~*=e_
 *    ,Z~   @@W    \.                           ] g-
 *    d`    ,8s     @i                          ]W`__
 *    @b V**   _W`Vs                        ,P~
 *    ['\=m__gmmZ*~   'i    _____             if    _________g
 *    W                ]mY~~~~~~~~*e_        _A=/~~~~~~   '~~@     mm-
 *    M                      __.    'Vc   ,=~                ]i   ]@@
 *    ].   ,m=*+m.           ~~~*s     \m/                   ]`   ]@@
 *    ][  iP,__ ][               '[     's                   ]s___g@@
 *     W   N/**_A`                WebMvcConfiguration      '.                  ][  '~~~
 *     ]i   ~~~\__                i       `                  ][
 *  ___gW    ,Z~`'Vs             g`       -                  ][
 * f`   !W   M W@i W          _g/`        ,                  ][
 *      ,@b  '\===f`                      ]                  ][    ,g.
 * +===f~ Mb                              Z                  ][    @@[
 *      gzY*W.                           i!                  ][   -@@!
 *    ,Z`   'Ms                         gb                   ]b____@@
 *    !b   ,gZVWs                     ,v`'\c.                ]~~~~**f
 *     ~***~`   VMm_                ,zf     YD-_.            ]
 *                '~*em__       __zf`        b  '~\=es____  ,@
 *                      ~~~~~~~~`            !i        ,~VP~V*
 *                                            WebMvcConfiguration.     ]7 ~@[
 *                                            ]AA=s. '~='WebMvcConfiguration[
 *                                            W V.       ~
 */
@RestController
@RequestMapping("/test")
public class TestController
{
    @Resource
    StudentService studentService;

    @Resource
    private StudentDao studentDao;

    @GetMapping(value = "/123")
    @DataSource(value = "mysql5717DataSource")
    public void get() throws Exception
    {
        System.out.println("============={}" + DataSourceSupport.get());
        for (int i = 0; i < 10; i++)
        {
            Student s = new Student();
            s.setName("name" + i);
//            s.setTenantId((long) i);
            s.setAssignType(AssignTypeEnum.NOT_ASSIGN);
            studentService.insert(s);
        }
    }

    @GetMapping(value = "/hehe")
    public void hehe(HttpServletResponse response)
    {
        A a = new A();
        a.outputCaptcha(response);
    }

    @GetMapping(value = "/qqq")
    @DataSource("mysql8012DataSource")
    public Object qqq(HttpServletResponse response)
    {
        List<Student> students = studentDao.selectList(new QueryWrapper<>());
        students.stream().parallel().forEach(System.out::println);
        IPage<Student> studentIPage = studentDao.selectPage(new Page<>(1, 10), new QueryWrapper<>());
        List<Student> records = studentIPage.getRecords();
        records.stream().parallel().forEach(System.out::println);
        return students;
    }

    @PostMapping(value = "/bbb")
    @DataSource("mysql8012DataSource")
    public Object bbb(@RequestBody Student student)
    {
        List<Student> a = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            Student s = new Student();
            s.setId(i + 1L);
            s.setName("nameCCCC" + i);
            s.setAssignType(AssignTypeEnum.XXX);
            a.add(s);
        }
        a.add(student);
        studentService.batchSaveOrUpdate(a);
//        studentService.batchUpdate(a);
//        studentService.batchInsert(a);
        return null;
    }
}
