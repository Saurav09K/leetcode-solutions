class Solution {
    public int minJumps(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean visited[] = new boolean[arr.length];
        int steps = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        while (!queue.isEmpty())
        {
            int size = queue.size();

            while (size-- > 0)
            {
                int x = queue.poll();

                if (x == arr.length - 1)
                    return steps;

                if (x + 1 < arr.length && !visited[x + 1])
                {
                    queue.add(x + 1);
                    visited[x + 1] = true;
                }
                if (x - 1 >= 0 && !visited[x - 1])
                {
                    queue.add(x - 1);
                    visited[x - 1] = true;
                }

                if (map.containsKey(arr[x]))
                {
                    for (int j : map.get(arr[x]))
                    {
                        if (!visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                    map.remove(arr[x]);
                }
            }
            steps++;
        }
        return steps;
    }

}