import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class Test extends Thread{

	@Override
	public void run() {
		getName();
	}
	
	public static void main(String[] args) throws Exception {
		String key= "00000:H_PUBS:XT-fcee1ad1-90bb-41f3-b7c4-4e2a3aa962eb";
		System.out.println(key.substring(13));

	}
	
	public static void getboolean(){
		String rtnStr = "{\"share\":false}";
        JSONObject jsonObj = JSON.parseObject(rtnStr);
        Object share = jsonObj.get("share");
        System.out.println( share );
        
	}
	
	//发送IOS过期证书
	public static void testSendMessage() throws Exception{
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance(); // 日历对象
		calendar.setTime(now); // 设置当前日期
		calendar.add(Calendar.MONTH, 1); // 加1个月份(提前一个月)
		Date expireTime = calendar.getTime();//当前日期
		String msg = "";
		String provisionTime = "2016-10-13";
		Date provisionDateTime = sdf.parse(provisionTime);
		if (diffDay(expireTime,provisionDateTime)) {// 调用推送接口
			msg="尊敬的管理员，iOS企业授权文件将在"+provisionTime+"，过期后iOS客户端将无法使用，请及时处理！";
			System.out.println(msg);
		}

		String iosTime = "2018-10-13";
		Date iosDateTime = sdf.parse(iosTime);
		if (diffDay(expireTime,iosDateTime)) {// 调用推送接口
			msg="尊敬的管理员，iOS企业发布证书将在"+iosTime+"到期，过期后iOS客户端将无法使用，请及时处理！";
			System.out.println(msg);
		}

		String pushTime = "2016-10-14";
		Date pushDateTime = sdf.parse(pushTime);
		
		if (diffDay(expireTime,pushDateTime)) {// 调用推送接口
			msg="尊敬的管理员，iOS企业推送证书将在"+pushTime+"到期，过期后iOS客户端将无法使用,请及时处理！";
			System.out.println(msg);

		}
	}
	private static boolean diffDay(Date smallTime, Date bigTime) {
		if (smallTime.compareTo(bigTime) < 0) {
			return false;
		}else {
			  long diff = smallTime.getTime() - bigTime.getTime();   
			  long days = diff / (1000 * 60 * 60 * 24);  
			 return days%5==0;	
		}
		
		
	}
}
