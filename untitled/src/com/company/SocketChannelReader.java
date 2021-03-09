package com.company;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SocketChannelReader {
    public static void main(String[] args) {
            new SocketChannelReader().getHTMLContent();
    }

    private Charset charset=Charset.forName("UTF-8");
    private SocketChannel channel;

    public void getHTMLContent(){

        try {
            connect();
            sendRequest();
            readResponse();
        } catch (IOException e) {
            System.out.println(e.toString());
        }finally {
            if(channel!=null){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private  void connect() throws IOException {
        InetSocketAddress socketAddress=new InetSocketAddress("www.taobao.com",80);
        channel=SocketChannel.open(socketAddress);
    }
    private void sendRequest() throws IOException {
        channel.write(charset.encode("GET"+"/document"+" "));
    }
    private  void readResponse() throws IOException {
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while (channel.read(buffer)!=-1){
              buffer.flip(); //flip()方法在读缓冲区字节操作之前调用
            System.out.println(charset.decode(buffer)); //charset.decode方法将字节转换为字符串
            buffer.clear();
        }
    }
}
