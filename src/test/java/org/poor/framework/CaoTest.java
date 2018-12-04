package org.poor.framework;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: CaoTest</p>
 * <p>Description: CaoTest</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/29 15:22</p>
 * @author cb
 * @version 1.0
 **/
public class CaoTest
{
    public static void main(String[] args)
    {
        System.load("F:\\workspace_idea_remark\\summer-util\\opencv\\x64\\opencv_java310.dll");
//        System.out.println(System.getProperty("java.library.path"));
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat eye = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("m = "+eye.dump());

    }
}
