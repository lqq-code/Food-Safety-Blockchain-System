package edu.smxy.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

import edu.smxy.db.CMDUs;
 
public class FileDownThread extends Thread {
		//文件保存路径
		private String fileDir;
		//socket服务器端口
		private int port;
		//是否停止
		private boolean stop=false;
		public String getFileDir() {
			return fileDir;
		}
		public void setFileDir(String fileDir) {
			this.fileDir = fileDir;
		}
		public int getPort() {
			return port;
		}
		public void setPort(int port) {
			this.port = port;
		}
		public boolean isStop() {
			return stop;
		}
		public void setStop(boolean stop) {
			this.stop = stop;
		}
		 public FileDownThread(int port,String fileDir) {
		    	this.port=port;
		    	this.fileDir=fileDir;
		    }
		
		
		@Override
		public void run() {
			    System.out.println("**********tcp服务器开启**************");
				Socket socket = null;
				try {
					ServerSocket ss =new ServerSocket(port);
					do {
						socket = ss.accept();
						 // public Socket accept() throws
						// IOException侦听并接受到此套接字的连接。此方法在进行连接之前一直阻塞。
						System.out.println("建立socket链接");
						DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
						//本地保存路径，文件名会自动从服务器端继承而来
						int bufferSize = 8192;
						byte[] buf = new byte[bufferSize];
						long passedlen = 0;
						long len = 0;
						
						//获取文件名
						String file = fileDir + inputStream.readUTF();
						DataOutputStream fileOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
						len = inputStream.readLong();
						System.out.println("文件的长度为:  " + len  + "\n");
						System.out.println("开始接收文件!" + "\n");
						
						while(true) {
								int read = 0;
								if (inputStream != null) {
									read = inputStream.read(buf);
								}
								passedlen += read;
								if(read == -1) {
									break;
								}
								fileOut.write(buf, 0, read);
								fileOut.flush();
								double a  = Double.valueOf(String.valueOf(passedlen))/Double.valueOf(String.valueOf(len))*100;
								System.out.println("文件完成度:  " +a+ "%");
						}
						fileOut.close();
					} while (!stop);
					System.out.println("*********************服务器关闭*********************");
				} catch (Exception e) {
						System.out.println("接收消息错误" + "\n");
						e.printStackTrace();
						return ;
				}
				
		}
		
}
