class Logger {

    /** Initialize your data structure here. */
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)) {
            if (timestamp - map.get(message) >= 10) {
                map.put(message, timestamp);
                return true;
            } else{
                return false;
            }
        } else {
            map.put(message, timestamp);
            return true;
        }
    }
}
