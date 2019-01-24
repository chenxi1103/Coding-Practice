//////////////////Iterator写的非常不熟练了，要多加练习！/////////////////////////////
public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> i;
    Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        i = vec2d.iterator();
        j = null;
    }

    @Override
    public Integer next() {
        // Write your code here
        if(!hasNext()){
            return null;
        }
        return j.next();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while((j == null || !j.hasNext()) && i.hasNext()){
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }

    @Override
    public void remove() {}
}
//////////////////////////////////////////////////////////////////////////////
public class Vector2D implements Iterator<Integer> {
    ArrayList<Integer> list;
    int count;
    int size;
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        list = new ArrayList<>();
        size = 0;
        count = 0;
        for(int i = 0; i < vec2d.size(); i++){
            size += vec2d.get(i).size();
            for(int j = 0; j < vec2d.get(i).size(); j++){
                list.add(vec2d.get(i).get(j));
            }
        }
    }

    @Override
    public Integer next() {
        // Write your code here
        return list.get(count++);
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        return count < size;
    }

    @Override
    public void remove() {}
}
