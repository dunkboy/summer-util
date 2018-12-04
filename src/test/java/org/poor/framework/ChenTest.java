package org.poor.framework;

import com.github.drinkjava2.jsqlbox.SqlBoxContext;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.poor.framework.test.dao.StudentDao;
import org.poor.framework.test.datasource.DataSourceSupport;
import org.poor.framework.test.domain.po.Student;
import org.poor.framework.test.enums.AssignTypeEnum;
import org.poor.framework.thirft.FRM_OBJ;
import org.poor.framework.thirft.RST_DETECT;
import org.poor.framework.thirft.Service;
import org.poor.framework.thirft.VideoProcessService;
import org.poor.framework.utils.annotation.DataSource;
import org.poor.framework.utils.json.FastJsonUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        Thread.sleep(5000);
        System.out.println("==========="+Thread.currentThread().getName());
//        Student s = new Student();
//        s.setName("而发热王若飞");
//        s.setTenantId(54L);
//        s.setAssignType(AssignTypeEnum.HAVE_ASSIGN);
//        sqlBoxContext.eInsert(s);
//        sqlBoxContext.nExecute("INSERT INTO `test`.`cb_student`( `tenant_id`, `del_flag`, `name`, `assign_type`) VALUES ( 333, 0, 'ggd烦烦烦', 888)");

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
        File file = new File("F:\\workspace_idea_remark\\summer-util\\src\\test\\java\\org\\poor\\framework\\chenbo999.jpg");
        System.load("F:\\workspace_idea_remark\\summer-util\\opencv\\x64\\opencv_java310.dll");
        TTransport transport9090 = new TSocket("172.16.2.70", 9090);
        TFramedTransport tFramedTransport9090 = new TFramedTransport(transport9090);
        TProtocol protocol9090 = new TCompactProtocol(tFramedTransport9090);
        VideoProcessService.Client client9090 = new VideoProcessService.Client(protocol9090);

        UUID uuid = UUID.randomUUID();
        transport9090.open();

        boolean b = client9090.start_cut_frame(uuid.toString(), "rtsp://admin:rm123456@172.16.2.131:554/h264/ch1/main/av_stream");
        ByteBuffer byteBuffer = null;
        if (b)
        {
            FRM_OBJ frame = null;
            try
            {
                frame = client9090.get_new_frame(uuid.toString());
            }
            catch (TException e)
            {
                if (client9090.stop_cut_frame(uuid.toString()))
                {
                    System.out.println("退出成功");
                }
                else
                {
                    System.out.println("退出失败");
                }
            }
            System.out.println("height==" + frame.height);
            System.out.println("width==" + frame.width);
            if (client9090.stop_cut_frame(uuid.toString()))
            {
                System.out.println("退出成功");
            }
            else
            {
                System.out.println("退出失败");
            }
            byteBuffer = frame.frame;
            int count = byteBuffer.array().length + 1;
//            Mat mat = new Mat();
            BufferedImage bufferedImage = BGR2BufferedImage(byteBuffer, frame.width, frame.height);
//            Mat mat = new Mat(frame.height, frame.width, CV_8UC4);
//
//            System.out.println(byteBuffer.array().length + 1);
//            byte[] buff = byteBuffer.array();
//            mat.put(0, 0, buff);
//
//            BufferedImage bufferedImage = Mat2BufImg(mat, ".jpg");
            ImageIO.write(bufferedImage, "jpg", file);
//            FileImageOutputStream imageOutput = new FileImageOutputStream(new File("F:\\workspace_idea_remark\\summer-util\\src\\test\\java\\org\\poor\\framework\\chenbo333"));
//            imageOutput.write(byteBuffer.array());
//            imageOutput.close();
//            FileOutputStream fis = new FileOutputStream("F:\\workspace_idea_remark\\summer-util\\src\\test\\java\\org\\poor\\framework\\chenbo333.jpg");
//            FileChannel channel = fis.getChannel();
//            channel.write(byteBuffer);
//            channel.close();

        }
        else
        {
            System.out.println("###失败###");
            return;
        }

        transport9090.close();

        try
        {
            TTransport transport = new TSocket("172.16.2.51", 8005);
            TFramedTransport tFramedTransport = new TFramedTransport(transport);
            TProtocol protocol = new TCompactProtocol(tFramedTransport);
            Service.Client client = new Service.Client(protocol);
            transport.open();

//            FileInputStream fis = new FileInputStream("F:\\workspace_idea_remark\\summer-util\\src\\test\\java\\org\\poor\\framework\\chenbo.jpg");
            FileInputStream fis = new FileInputStream(file);
            FileChannel channel = fis.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            System.out.println(map.position());
            System.out.println(map.limit());

            RST_DETECT rst_detect = client.detect_Image(map);
            System.out.println(FastJsonUtil.toJSONString(rst_detect));
//            channel.close();
//            fis.close();
            transport.close();
        }
        catch (TTransportException e)
        {
            throw e;
        }
        catch (TException e)
        {
            throw e;
        }

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

    public static BufferedImage Mat2BufImg(Mat matrix, String fileExtension)
    {
        // convert the matrix into a matrix of bytes appropriate for
        // this file extension
        MatOfByte mob = new MatOfByte();
        Imgcodecs.imencode(fileExtension, matrix, mob);
        // convert the "matrix of bytes" into a byte array
        byte[] byteArray = mob.toArray();
        BufferedImage bufImage = null;
        try
        {
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bufImage;
    }


    public static BufferedImage BGR2BufferedImage(ByteBuffer src, int width, int height) {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Raster ra           = image.getRaster();
        DataBuffer out      = ra.getDataBuffer();
        DataBufferByte db   = (DataBufferByte)out;

        ByteBuffer.wrap(db.getData()).put(src);

        return image;
    }

}
