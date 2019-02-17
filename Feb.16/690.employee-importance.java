class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees) {
            map.put(e.id, e);
        }
        return importantSum(map.get(id), map);

    }
    private int importantSum(Employee employee, Map<Integer, Employee> map) {
        int sum = employee.importance;
        for(int e : employee.subordinates) {
            sum += importantSum(map.get(e), map);
        }
        return sum;
    }
}
