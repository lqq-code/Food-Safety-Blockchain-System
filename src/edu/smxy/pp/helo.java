package edu.smxy.pp;

import java.util.Arrays;

import edu.smxy.blockchain.BlockDao;
import edu.smxy.user.AssetsDao;

public class helo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] t=jw("66",4);
		
		for(int i=0;i<t.length;i++)
		{
			System.out.println(t[i]);
		}
	}
	//首先写功能：健步鸡王，一天24小时传入的是用户名，返回的是顺序列表（鸡的编号string）
	public static String[] jw(String name,int n){
		AssetsDao da=new AssetsDao();
		String b[]=da.query(name,10);
		BlockDao dao=new BlockDao();
		//每一只鸡的步数之和
		int num[] =new int[5];
		String numt[] =new String[5];
		
		for(int j=0;j<5;j++){
			String ta=b[j];
			int time=dao.findlast(ta);
			numt[j]=ta;
			for(int i=time-n;i<time;i++)
			{	
				num[j]+=Integer.valueOf(dao.find(ta, i).data);
			}
			System.out.println(num[j]);
			System.out.println(numt[j]);
		}
		
		
		int tmp;
		String tmpt;
		for (int i = 0; i < num.length-1; i++) {
			
			for (int j = i+1; j < num.length; j++) {
				if(num[i]>num[j]){
					tmp = num[j];
					num[j] = num[i];
					num[i] = tmp;
					
					tmpt=numt[j];
					numt[j] = numt[i];
					numt[i] = tmpt;
				}
				System.out.println(Arrays.toString(num));
			}			
		}
		
		return numt;
		
	}
	

}
