package edu.smxy.listener;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.smxy.db.CMDUs;

public class FbsRecieveThread extends Thread{
	public static  String str="";
	DatagramSocket socket;
    public FbsRecieveThread(DatagramSocket socket) {
    	this.socket=socket;
    }
    @Override
    public void run() {
    	
    	//建立udp的服务 ，并且要监听一个端口。
        //准备空的数据包用于存放数据。
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length); // 1024
        //调用udp的服务接收数据
        System.out.print(socket.getLocalPort()+"开始接受数据");
        String msg = "";
        String fb[];
        String tmp[];
        while(true){
        	  try {
				socket.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //receive是一个阻塞型的方法，没有接收到数据包之前会一直等待。 数据实际上就是存储到了byte的自己数组中了。
        	  if(null!=packet){
        		  //接受到数据进行还原处理-------------------
                  DataInputStream istream = new DataInputStream(new ByteArrayInputStream(packet.getData(), packet.getOffset(), packet.getLength()));  
                  try {
					msg = istream.readUTF();
					System.out.println("信息"+msg);  
	                  istream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
                  //-----------还原完成-------------
                  //-----数据处理开始-----数据库的还原---
                  tmp=msg.split("#");
                  if(tmp[1].equals("sendover")&&tmp[2]!=null)//接收完毕处理sendover#008
                  {
                	  File file=new File("c:/fbs/"+tmp[2]+".sql");
                	  CMDUs.inport("blockchain",file);
                	  System.out.println("恢复完成");
                  }
                  if(tmp[0].equals("hf")&&tmp[1]!=null)//最优请求返回处理
                  {
                	  //如何实现最优的查询呢，首先要比较链长，然后是绑定ip，最后返回IP
                	  

                  }
                  msg="";
                  //--------------------------------
        	  }
        }
    } 
}
