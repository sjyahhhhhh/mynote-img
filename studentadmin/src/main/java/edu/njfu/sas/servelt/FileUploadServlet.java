package edu.njfu.sas.servelt;

import edu.njfu.sas.util.FileUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置response编码
        response.setContentType("text/html;charset=utf-8");
        //创建临时文件夹
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //3设置临时文件位置
        File file = new File("C:\\sjy\\");
        //4文件是否存在，不存在就创建
        if (!file.exists()){
            file.mkdirs();
        }
        //5.把file加入到factory中
        diskFileItemFactory.setRepository(file);
        //6.从临时文件夹中读取数据
        //
        ServletFileUpload servleFileUpload = new ServletFileUpload(diskFileItemFactory);


        try {
            List<FileItem> fileItems = servleFileUpload.parseRequest(request);
            //7.遍历
            for (FileItem item:fileItems){
                if (item.isFormField()) {
                    System.out.println("上传者" + item.getString() );
                }else{
                    //10是上传的文件，只传一个文件
                    //10.1获取上传文件的文件名
                    String fileName = item.getName();
                    System.out.println(fileName);
                    if(fileName!=null&&!fileName.equals("")){
                        //10.2修改上传文件的文件名
                        fileName= FileUtil.getRandomFileName(fileName);
                        System.out.println(fileName);
                        //10.3把文件保存到指定位置
                        String path = "C:\\sjy\\";
                        //10.4创建文件
                        File newfile = new File(path+fileName);
                        //10.5获取输入流
                        InputStream inputStream = item.getInputStream();
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(newfile));
                        byte[] buffer=new byte[1024];
                        int len;
                        //把输入流的数据写到文件中
                        while ((len=bufferedInputStream.read(buffer))>0){
                            outputStream.write(buffer,0,len);
                        }
                        //关闭流
                        outputStream.close();
                        bufferedInputStream.close();
                        //删除临时文件
                        item.delete();
                        //提示信息文件保存成功
                        System.out.println("文件保存成功");

                    }

                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请使用Post方式上传文件");
    }
}
