package com.crowdfunding.framework.util;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 对象序列化
 * Created by lucy on 2017/12/11.
 */
public class SerializeUtil {

    /**
     * @Description 序列化
     * @MethodName serialize
     * @param object
     * @return byte[]
     * @author lucy
     * @Date 2017/12/11 14:41
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * @Description 反序列化
     * @MethodName unserialize
     * @param bytes
     * @return java.lang.Object
     * @author lucy
     * @Date 2017/12/11 14:41
     */
    public static Object unserialize( byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * @Description 压缩byte
     * @MethodName compress
     * @param bt
     * @Return byte[]
     * @Authorlucy
     * @CreateDate 2017/12/11 14:41
     * @UpdateBy
     * @UpdateDate
     */
    public static byte[] compress(byte[] bt){
        ByteArrayOutputStream bos=null;
        GZIPOutputStream gzipos=null;
        try {
            bos=new ByteArrayOutputStream();
            gzipos=new GZIPOutputStream(bos);
            gzipos.write(bt);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeStream(gzipos);
            closeStream(bos);
        }
        return bos == null ? null : bos.toByteArray();
    }

    /**
     * @Description 解压byte
     * @MethodName unCompress
     * @param bt
     * @Return byte[]
     * @Author lucy
     * @CreateDate 2017/12/11 14:41
     * @UpdateBy
     * @UpdateDate
     */
    public static byte[] unCompress(byte[] bt){
        ByteArrayOutputStream byteAos=null;
        ByteArrayInputStream byteArrayIn=null;
        GZIPInputStream gzipIn=null;
        try {
            byteArrayIn=new ByteArrayInputStream(bt);
            gzipIn=new GZIPInputStream(byteArrayIn);
            byteAos=new ByteArrayOutputStream();
            byte[] b=new byte[4096];
            int temp = -1;
            while((temp=gzipIn.read(b))>0){
                byteAos.write(b, 0, temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            closeStream(byteAos);
            closeStream(gzipIn);
            closeStream(byteArrayIn);
        }
        return byteAos.toByteArray();
    }

    /**
     * @Description 关闭流
     * @MethodName closeStream
     * @param oStream
     * @Return void
     * @Author lucy
     * @CreateDate 2017/12/11 14:41
     * @UpdateBy
     * @UpdateDate
     */
    public static void closeStream(Closeable oStream){
        if(null!=oStream){
            try {
                oStream.close();
            } catch (IOException e) {
                oStream=null;
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String str = "";
        byte[] byte1 = str.getBytes();
        byte[] byte2 = compress(byte1);
        System.out.println(byte1.length);
        System.out.println(byte2.length);
        byte[] byte3 = unCompress(byte2);
        String s = new String(byte3);
        System.out.println(s);
    }

}
