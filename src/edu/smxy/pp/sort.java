package edu.smxy.pp;
import java.util.Arrays;

import edu.smxy.blockchain.BlockDao;
import edu.smxy.info.i.tinfoDao;
import edu.smxy.user.AssetsDao;

public class sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static String pp(int  t){
		return "hell9o";
	}
	//首先写功能：健步鸡王，一天24小时传入的是用户名，返回的是顺序列表（鸡的编号string）
	public static Px[] jw(int  t,String name,int time){
		AssetsDao da=new AssetsDao();
		String b[]=da.query(name,t);
		//t是查看几只鸡
		BlockDao dao=new BlockDao();
		//每一只鸡的步数之和
		int num[] =new int[t];
		for(int j=0;j<t;j++){
			String ta=b[j];
			int tp=dao.findlast(ta);
			for(int i=tp-time;i<=tp;i++)
			{	
				num[j]+=Integer.valueOf(dao.find(ta, i).data);
			}
		}
		//num存放的是步数，b存放的是名称
		Px sort1[]=new Px[num.length];
		tinfoDao cddao=new tinfoDao();
		
		for(int i=0;i<num.length;i++){
			sort1[i]=new Px(b[i],num[i],
					cddao.query(b[i]).getPz()
					,cddao.query(b[i]).getCd()
					,cddao.query(b[i]).getRlsj());
		}
		Arrays.sort(sort1);
		return sort1;
	}
}
