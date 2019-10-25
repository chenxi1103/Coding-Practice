class Solution {
    class WorkerBike {
        int worker;
        int bike;
        public WorkerBike(int worker, int bike) {
            this.worker = worker;
            this.bike = bike;
        }
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        Map<Integer, List<WorkerBike>> map = new TreeMap<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance =
                    calculate_manhattan(workers[i][0], workers[i][1], bikes[j][0], bikes[j][1]);
                if (!map.containsKey(distance)) {
                    map.put(distance, new ArrayList<WorkerBike>());
                }
                map.get(distance).add(new WorkerBike(i, j));
            }
        }
        boolean[] workerMark = new boolean[workers.length];
        boolean[] bikeMark = new boolean[bikes.length];
        int[] result = new int[workers.length];
        for (int key : map.keySet()) {
            List<WorkerBike> list = map.get(key);
            Collections.sort(list, (a, b) -> Integer.compare(a.worker, b.worker));
            for (WorkerBike wb : list) {
                if (!workerMark[wb.worker] && !bikeMark[wb.bike]) {
                    result[wb.worker] = wb.bike;
                    workerMark[wb.worker] = true;
                    bikeMark[wb.bike] = true;
                }
            }
        }
        return result;
    }
    private int calculate_manhattan(int worker_x, int worker_y, int bikes_x, int bikes_y) {
        return Math.abs(worker_x - bikes_x) + Math.abs(worker_y - bikes_y);
    }
}
