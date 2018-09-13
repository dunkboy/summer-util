package org.poor.framework.utils.csv;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.util.ObjectUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: CsvUtil</p>
 * <p>Description: CsvUtil</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/9/12 17:38</p>
 * @author cb
 * @version 1.0
 **/


public abstract class CsvUtil
{
    /**
     * <p>Description: read csv into bean</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: poor</p>
     * <p>CreateTime:2018/9/12 17:52</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  filePath
     * @param  type
     * @param  separator
     * @return List<T>
     */
    public static <T> List<T> parseCsv(String filePath, Class<? extends T> type, Character separator) throws FileNotFoundException
    {
        if (ObjectUtils.isEmpty(separator))
        {
            separator = ',';
        }
        return new CsvToBeanBuilder<T>(new FileReader(filePath)).withType(type).withSeparator(separator).build().parse();
    }

    /**
     * <p>Description: read csv include header and first line</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: poor</p>
     * <p>CreateTime:2018/9/12 17:55</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  filePath
     * @return Map
     */
    public static Map<String, String> parseCsvOneLine(String filePath) throws IOException
    {
        return new CSVReaderHeaderAware(new FileReader(filePath)).readMap();
    }

    /**
     * <p>Description: write csv from java beans </p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: poor</p>
     * <p>CreateTime:2018/9/12 18:04</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  beans
     * @return filePath
     */
    public static <T> void generateCsvFromBean(List<T> beans, String filePath) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException
    {
        Writer writer = new FileWriter(filePath);
        StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();
        beanToCsv.write(beans);
        writer.close();
    }

}
