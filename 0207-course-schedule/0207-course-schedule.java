class Solution {
    public boolean dfs(int curr, List<List<Integer>> adj, boolean visited[], boolean pathVisited[])
    {
        visited[curr] = true;
        pathVisited[curr] = true;
        
        for(int neighbor : adj.get(curr))
        {
            if(!visited[neighbor])
            {
                if(dfs(neighbor,adj,visited,pathVisited)) return true;
            }
            else if(pathVisited[neighbor])
            {
                return true;
            }
        }
        pathVisited[curr] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++)
        {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1]; 

            adj.get(b).add(a);
        }

        boolean visited[] = new boolean[numCourses];
        boolean pathVisited[] = new boolean[numCourses];


        boolean hasCycle = false;
        for(int i=0; i<adj.size(); i++)
        {
            if(!visited[i])
            {
                if(dfs(i,adj,visited,pathVisited))
                {
                    hasCycle = true;
                    return false;
                }
            }
        }
        return true;
        
    }
}