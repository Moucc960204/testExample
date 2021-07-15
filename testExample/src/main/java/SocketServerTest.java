import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: testExample
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-15 09:00
 **/
public class SocketServerTest {

    public static void main(String[] args) {
        try {
            //定义ServerSocket和Socket对象
            ServerSocket serverSocket = new ServerSocket(1314);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GBK");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String returnInfo = bufferedReader.readLine();
            System.out.println("服务器端返回数据为：" + returnInfo);
            /*byte[] buf = new byte[1024];
            int length = inputStream.read(buf);
            System.out.println("Server:收到客户端的响应====>" + new String(buf, 0, length));*/

            //定义发送字符串，即客户端收到的信息
            String sendString = "hello！我是服务端...";
            //定义OutputStream类
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(sendString.getBytes());
            outputStream.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
