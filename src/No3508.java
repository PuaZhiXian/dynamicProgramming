import java.util.*;

public class No3508 {
    public static void main(String[] args) {
        No3508 o = new No3508();
        o.temp();
    }

    private void temp() {

//        getCount(Arrays.asList(4, 6, 7, 7, 7, 7, 10, 20, 50), 1, 1000);//0
//        getCount(Arrays.asList(4, 6, 7, 7, 7, 7, 10, 20, 50), 5, 1000);//1
//        getCount(Arrays.asList(4, 6, 7, 7, 7, 7, 10, 20, 50), 7, 1000);//2
//        getCount(Arrays.asList(4, 6, 7, 7, 7, 7, 10, 20, 50), 30, 1000);//8
//        getCount(Arrays.asList(4, 6, 7, 7, 7, 7, 10, 20, 50), 60, 1000);//0

//        getCount(Arrays.asList(4, 6, 7, 7, 7, 7, 10, 20, 50), -100, 5);//0
//        getCount(Arrays.asList(4, 6, 7, 7, 7, 7, 10, 20, 50), -100, 7);//5
//        getCount(Arrays.asList(4, 6, 7, 7, 7, 7, 10, 20, 50), -100, 30);//7
//        getCount(Arrays.asList(4, 6, 7, 7, 7, 7, 10, 20, 50), -100, 1);//0

    }

    class Router {

        private final Map<Long, int[]> metaInfo = new HashMap<>();
        private final Map<Integer, List<Integer>> destMap = new HashMap<>();
        private final Queue<Long> keyset = new LinkedList<>();
        int memoryLimit;

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
        }

        //FIXME: way to generate a unique key from multiple val
        private long encode(final int source, final int destination, final int timestamp) {
            return ((long) source << 40) | ((long) destination << 20) | timestamp;
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            final long key = encode(source, destination, timestamp);
            //FIXME: search by map will o(1) , if use queue will o(n)
            if (metaInfo.containsKey(key)) {
                return false;
            }

            if (metaInfo.size() >= memoryLimit) {
                forwardPacket();
            }

            keyset.add(key);
            metaInfo.put(key, new int[]{source, destination, timestamp});
            List<Integer> list = destMap.getOrDefault(destination, new ArrayList<>());
            list.add(timestamp);
            destMap.put(destination, list);

            return true;
        }

        public int[] forwardPacket() {
            if (keyset.isEmpty()) {
                return new int[0];
            }
            final long key = keyset.poll();
            int[] info = metaInfo.remove(key);
            destMap.get(info[1]).remove(0);
            return info;
        }

        public int getCount(int destination, int startTime, int endTime) {
            List<Integer> timeList = destMap.getOrDefault(destination, new ArrayList<>());
            if (timeList.isEmpty()) {
                return 0;
            }
            if (timeList.get(0) > endTime) {
                return 0;
            }
            if (timeList.get(timeList.size() - 1) < startTime) {
                return 0;
            }
            int start = getFirstGe(timeList, startTime);
            int end = getLastLe(timeList, endTime);
            return end - start + 1;
        }

        private int getFirstGe(List<Integer> list, int target) {
            int left = 0;
            int right = list.size() - 1;
            int view = right;

            while (right >= left) {
                int mid = (right + left) / 2;
                int midVal = list.get(mid);

                if (midVal < target) {
                    left = mid + 1;
                } else if (midVal == target) {
                    view = mid;
                    right = mid - 1;
                } else {
                    view = mid;
                    right = mid - 1;
                }
            }
            return view;
        }

        private int getLastLe(List<Integer> list, int target) {
            int left = 0;
            int right = list.size() - 1;
            int view = 0;

            while (right >= left) {
                int mid = (right + left) / 2;
                int midVal = list.get(mid);

                if (midVal < target) {
                    view = mid;
                    left = mid + 1;
                } else if (midVal == target) {
                    view = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return view;
        }


    }
} 
