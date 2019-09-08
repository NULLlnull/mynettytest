package udp;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.InternetHeaders;

import java.io.IOException;
import java.net.*;
//发送端
public class Client {
    public static void main(String[] args) throws UnknownHostException {
        // 广播的实现 :由客户端发出广播，服务器端接收
        String host = "255.255.255.255";//广播地址
        int port = 9999;//广播的目的端口
        String message = InetAddress.getLocalHost().getHostAddress();//用于发送的字符串
        try {
            InetAddress adds = InetAddress.getByName(host);
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(message.getBytes(),
                    message.length(), adds, port);
            ds.send(dp);
            ds.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
