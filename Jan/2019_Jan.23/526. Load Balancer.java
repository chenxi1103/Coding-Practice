public class LoadBalancer {
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    Random random = new Random();
    public LoadBalancer() {
        // do intialization if necessary
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
        if(!map.containsKey(server_id)){
            list.add(server_id);
            int index = list.size() - 1;
            map.put(server_id, index);
        }
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
        if(!map.containsKey(server_id)) return;
        int index = map.get(server_id);
        int lastId = list.get(list.size() - 1);
        list.set(index, lastId);
        map.put(lastId, index);
        map.remove(server_id);
        list.remove(list.size() - 1);
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
        return list.get(random.nextInt(list.size()));
    }
}
