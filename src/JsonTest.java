import org.apache.commons.lang.StringEscapeUtils;


public class JsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String commentJson = "{bizId: '575e267a60b232d8537a204a', bizType: 'freeflow_qingjia'}";
//		
//		JSONObject queryJson = JSONObject.fromObject(commentJson);
//		String bizId = queryJson.getString("bizId");
//		String bizType = queryJson.getString("bizType");
//		System.out.println("bizId="+bizId);
//		System.out.println("bizType="+bizType);
//		String[] ids = {"1234","1234"};
		
//		String jsonString = "{\"count\":15,\"apps\":[{\"FAppID\":1005},{\"FAppID\":8009}]}";
//		System.out.println(JSONObject.fromObject(jsonString).toString());;
		String name2Id = "{&quot;王东&quot;:&quot;87131f5f-4111-11e7-8825-005056ac6b20&quot;}";
		name2Id = StringEscapeUtils.unescapeHtml(name2Id);
		System.out.println(name2Id);
	}

}
