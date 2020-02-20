class TimeMap {
    public Map<String, Map<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        } else {
            map.put(key, new HashMap<>());
            map.get(key).put(timestamp, value);
        }
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            Map<Integer, String> currMap = map.get(key);
            if (currMap.containsKey(timestamp)) return currMap.get(timestamp);
            else {
                while (timestamp > 0) {
                    if (currMap.containsKey(--timestamp)) return currMap.get(timestamp);
                }
            }
        }
        return "";
    }
}

// TreeMap有一个方法，TreeMap.floorkey(key)可以return the greatest key less than or equal to the given key,简直为这题设计的！！！
class TimeMap {
    public Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer, String> currMap = map.get(key);
            return currMap.floorKey(timestamp) == null ? "" : currMap.get(currMap.floorKey(timestamp));
        }
        return "";
    }
}
