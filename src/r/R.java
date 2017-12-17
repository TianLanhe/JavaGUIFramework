package r;

import java.util.HashMap;

public class R {
	private static R instance = null;
	private HashMap<String, Object> map;

	private R() {
		map = new HashMap<String, Object>();
	}

	public static R getInstance() {
		if (instance == null)
			instance = new R();
		return instance;
	}

	public void register(String key, Object value) throws Exception {
		if (map.containsKey(key))
			throw new Exception("the key \"" + key + "\" has already existed.");
		map.put(key, value);
	}

	public void unregister(String key) throws Exception {
		if (!map.containsKey(key))
			throw new Exception("the key \"" + key + "\" doesn't exist.");
		map.remove(key);
	}

	public Object getObject(String str) {
		if (!map.containsKey(str))
			return null;
		return map.get(str);
	}

}
