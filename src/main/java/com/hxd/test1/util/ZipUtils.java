package com.hxd.test1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
/**
 *          压缩文件
 * @param zipFileName:压缩后的文件
 * @param file :要压缩的文件
 *
 * */
    public static void compressFile(String zipFileName, File file) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream(zipFileName);
        ZipOutputStream zipOutputStream=new ZipOutputStream(fileOutputStream);
        zip(zipOutputStream,file,"");
    }

    public static void zip(ZipOutputStream out,File f,String base) throws Exception{
        if(f.isDirectory()){
            System.out.println("........");
            File[] files = f.listFiles();
            out.putNextEntry(new ZipEntry(base+"/"));
            base=base.length()==0?"":base+"/";
            System.out.println(base);
            for (int i=0;i<files.length;i++){
                zip(out,files[i],base+files[i]);
            }
        }else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            //System.out.println(base);
            while ((b=in.read())!=-1){
                out.write(b);
            }
            in.close();
        }
    }

    public static void decompress(String fileName){
        ZipInputStream zin;
        try {
            zin=new ZipInputStream(new FileInputStream(fileName));
            ZipEntry entry = zin.getNextEntry();
            while (((entry=zin.getNextEntry())!=null)&&!entry.isDirectory()){
                //如果entry不为空，并不在同一目录下
                String name = entry.getName();
                String realName = name.substring(name.lastIndexOf("\\"));
                String replace = name.replace(realName, "");
                System.out.println(realName);
                System.out.println(replace);

                File file = new File(replace+"\\test\\"+realName);

                System.out.println(file);
                if(!file.getParentFile().exists()){
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                zin.closeEntry();
                System.out.println(entry.getName()+"解压成功");

            }
            zin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            //File file = new File("C:\\Users\\sxtc\\Desktop\\侯晓东7月份报销统计.xlsx");
            //System.out.println(file.exists());

            compressFile("C:\\Users\\sxtc\\Desktop\\测试压缩.zip",new File("C:\\Users\\sxtc\\Desktop\\img"));
            System.out.println("压缩完成");
            //decompress("C:\\Users\\sxtc\\Desktop\\测试压缩.zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
