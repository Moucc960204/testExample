package com.test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 * @program: testExample
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-15 08:53
 **/
public class SocketClientTest {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1314);
            //2.获取客户端输出流
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("连上服务端");
            //3.向服务端发送消息
            outputStream.write(new String("hello").getBytes());
            outputStream.flush();
            System.out.println("成功向服务器发送消息");
            //4.获取输入流，并读取服务器端的响应信息
            InputStream inputStream = socket.getInputStream();
            byte[] buf = new byte[1024];
            int length;
            while ((length = inputStream.read(buf)) != -1){
                System.out.println("Client:收到来自客户端的响应====>" + new String(buf, 0, length));
            }
/*            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String returnInfo = bufferedReader.readLine();
            System.out.println("服务器端返回数据为：" + returnInfo);*/
            //4.关闭资源
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
