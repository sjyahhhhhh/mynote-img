package edu.njfu.sas.servelt;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //设置resp的编码
        response.setContentType("text/html;chaarset=utf-8");
        //获取下载文件名
        String filename = request.getParameter("filename");
//        filename=new String(filename.getBytes("ios-8859-1"),"utf-8");
        //确定下载目录
        String downloadpath="/download/";
        //设置响应头
        response.addHeader("Content-Type","application/octet-stream");
        response.addHeader("Content-Type","attachment;filename="+filename);
        //读取文件
        InputStream inputStream = getServletContext().getResourceAsStream(downloadpath + filename);
        //获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //把输入流中的数据，写入到输出流
        byte[] bytes = new byte[1024];
        int len=0;
        while((len=inputStream.read(bytes))>0){
            outputStream.write(bytes,0,len);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
