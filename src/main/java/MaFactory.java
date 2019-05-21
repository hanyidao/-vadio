import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaFactory {
	
	private static Map<String, Object> map = new HashMap<>();
	

	public static Map<String, Object> createLayuiSelectMap(List<Map<String, Object>> list,String msg,int count)
	{
		map.put("code", 0);
		map.put("data", list);
		map.put("count", count);
		return map;
	}
}
