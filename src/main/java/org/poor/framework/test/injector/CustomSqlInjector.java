package org.poor.framework.test.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDelete;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteBatchByIds;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteById;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByMap;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectBatchByIds;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectById;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectByMap;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectCount;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectList;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectMaps;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectMapsPage;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectObjs;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectOne;
import com.baomidou.mybatisplus.extension.injector.methods.LogicSelectPage;
import com.baomidou.mybatisplus.extension.injector.methods.LogicUpdate;
import com.baomidou.mybatisplus.extension.injector.methods.LogicUpdateById;
import org.poor.framework.test.injector.methods.BatchInsert;
import org.poor.framework.test.injector.methods.BatchReplaceInto;
import org.poor.framework.test.injector.methods.BatchSaveOrUpdate;
import org.poor.framework.test.injector.methods.BatchUpdate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: CustomSqlInjector</p>
 * <p>Description: CustomSqlInjector</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/6 20:45</p>
 * @author cb
 * @version 1.0
 **/
public class CustomSqlInjector extends AbstractSqlInjector
{
    @Override
    public List<AbstractMethod> getMethodList()
    {
        return Stream.of(
                new Insert(),
                new LogicDelete(),
                new LogicDeleteByMap(),
                new LogicDeleteById(),
                new LogicDeleteBatchByIds(),
                new LogicUpdate(),
                new LogicUpdateById(),
                new LogicSelectById(),
                new LogicSelectBatchByIds(),
                new LogicSelectByMap(),
                new LogicSelectOne(),
                new LogicSelectCount(),
                new LogicSelectMaps(),
                new LogicSelectMapsPage(),
                new LogicSelectObjs(),
                new LogicSelectList(),
                new LogicSelectPage(),
                new BatchInsert(),
                new BatchUpdate(),
                new BatchSaveOrUpdate(),
                new BatchReplaceInto()
        ).collect(Collectors.toList());
    }
}
