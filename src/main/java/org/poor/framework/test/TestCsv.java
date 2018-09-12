package org.poor.framework.test;

import com.opencsv.bean.CsvBindByName;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: TestCsv</p>
 * <p>Description: TestCsv</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/9/12 16:03</p>
 * @author cb
 * @version 1.0
 **/


public class TestCsv
{
//    @CsvBindByName
    private String header1;
    @CsvBindByName
    private String header2;
    @CsvBindByName
    private String header3;
    @CsvBindByName
    private String header4;

    public String getHeader1()
    {
        return header1;
    }

    public void setHeader1(String header1)
    {
        this.header1 = header1;
    }

    public String getHeader2()
    {
        return header2;
    }

    public void setHeader2(String header2)
    {
        this.header2 = header2;
    }

    public String getHeader3()
    {
        return header3;
    }

    public void setHeader3(String header3)
    {
        this.header3 = header3;
    }

    public String getHeader4()
    {
        return header4;
    }

    public void setHeader4(String header4)
    {
        this.header4 = header4;
    }
}
