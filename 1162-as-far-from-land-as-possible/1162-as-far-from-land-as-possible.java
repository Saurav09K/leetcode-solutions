class Solution {
    public int maxDistance(int[][] arr) {
        int row=arr.length;
        int col=arr[0].length;

        Queue<int[]> queue =new LinkedList<>();
        boolean visited[][]=new boolean[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(arr[i][j]==1)
                {
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }

        // EDGE CASE FIX: If no land (size 0) or all land (size row*col), return -1
        if (queue.isEmpty() || queue.size() == row * col) {
            return -1;
        }

        int direction[][]={{-1,0},{1,0},{0,-1},{0,1}};

        int level=0;

        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            while(size-->0)
            {
                int curr[] = queue.poll();
                int r=curr[0];
                int c=curr[1];

                for(int dir[] : direction)
                {
                    int newRow=r+dir[0];
                    int newCol=c+dir[1];

                    if(newRow>=0 && newRow<row && newCol>=0 && newCol<col && !visited[newRow][newCol]){
                        visited[newRow][newCol]=true;
                        queue.add(new int[]{newRow,newCol});
                    }


                }

            }
            level++;
        }
        
        return level-1;
        
    }
}