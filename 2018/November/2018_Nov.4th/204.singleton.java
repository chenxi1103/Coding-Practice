class Solution {
    /**
     * @return: The same instance of this class every time
     * java中最常见的设计模式：singleton
     * 永远只能有一个被实例化，如果没有实例化就将其实例化，如果实例化过了，
     * 返回这个实例
     */
    public static Solution instance = null;
    public static Solution getInstance() {
        // write your code here
        if(instance == null){
            instance = new Solution();
        }
        return instance;
    }
};
