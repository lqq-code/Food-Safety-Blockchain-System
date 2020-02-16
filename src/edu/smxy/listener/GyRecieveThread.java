package edu.smxy.listener;

import javax.servlet.ServletContext;

import edu.smxy.blockchain.Block;
import edu.smxy.blockchain.BlockDao;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GyRecieveThread extends Thread {
	private DatagramSocket socket;
	public static String str = "";

	public GyRecieveThread(DatagramSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute(socket);
	}

	public static void execute(DatagramSocket socket) {
		BlockDao dao= new BlockDao();
		
		try {
			byte[] bs = new byte[1024 * 64];
			DatagramPacket packet = new DatagramPacket(bs, bs.length);
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					if (str.indexOf("#") != -1) {
						String s[] = str.split("#");
						System.out.println(str + ":" + s[0] + "s[1]");
						if (s[0] != "") {
							System.out.println("存入数据" + s[1]);
							if(!dao.checkta(s[0]))
					        	dao.createTable(s[0]);
							int x = dao.findlast(s[0]);
							Block t = dao.find(s[0], x);
							Block block = new Block(s[1], t.hash);
							dao.insert(s[0], block);
							if (s[2] != null) {
								System.out.println("存入温度数据" + s[2]);
							}
							new Gysendstr("step_clear").start();
						}
					}
					str = "";
				}
			}, 0, 1000 * 10);
			while (true) {
				socket.receive(packet);
				if (null != packet) {
					try {
						System.out.print("接受数据");
						str = new String(bs, 0, packet.getLength());
						System.out.println(str);
					} catch (Exception e) {
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
