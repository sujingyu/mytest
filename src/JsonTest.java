import net.sf.json.JSONObject;

public class JsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String commentJson = "{bizId: '575e267a60b232d8537a204a', bizType: 'freeflow_qingjia'}";
		JSONObject queryJson = JSONObject.fromObject(commentJson);
		String bizId = queryJson.getString("bizId");
		String bizType = queryJson.getString("bizType");
		System.out.println("bizId="+bizId);
		System.out.println("bizType="+bizType);

	}

}
