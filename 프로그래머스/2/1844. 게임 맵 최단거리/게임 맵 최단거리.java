import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int xLen = maps.length;
        int yLen = maps[0].length;

        boolean[][] visited = new boolean[xLen][yLen];

        return bfs(visited, new OffsetNode(0,0), maps);
    }

    int bfs(boolean[][] visited, OffsetNode offset, int[][] maps){
        Queue<OffsetNode> q = new LinkedList<OffsetNode>();
        int[][] steps = new int[maps.length][maps[0].length];


        q.add(offset);
        visited[offset.x][offset.y]  = true;
        steps[offset.x][offset.y]  = 1;

        while(!q.isEmpty()){

            OffsetNode pollNode = q.poll();


            if(pollNode.x == maps.length-1 && pollNode.y == maps[0].length-1){
                return steps[pollNode.x][pollNode.y];
            }

            // west
            if(pollNode.y-1 >=0 && maps[pollNode.x][pollNode.y-1] == 1 && visited[pollNode.x][pollNode.y-1] != true){
                q.add(new OffsetNode(pollNode.x, pollNode.y-1));
                visited[pollNode.x][pollNode.y-1] = true;
                steps[pollNode.x][pollNode.y-1] = steps[pollNode.x][pollNode.y] + 1;
            }
            // north
            if(pollNode.x -1 >=0 && maps[pollNode.x-1][pollNode.y] == 1 && visited[pollNode.x-1][pollNode.y] != true){
                q.add(new OffsetNode(pollNode.x-1, pollNode.y));
                visited[pollNode.x-1][pollNode.y] = true;
                steps[pollNode.x-1][pollNode.y] = steps[pollNode.x][pollNode.y] + 1;
            }

            // south
            if(pollNode.x+1 < maps.length && maps[pollNode.x+1][pollNode.y] == 1 && visited[pollNode.x+1][pollNode.y] != true){
                q.add(new OffsetNode(pollNode.x+1, pollNode.y));
                visited[pollNode.x+1][pollNode.y] = true;
                steps[pollNode.x+1][pollNode.y] = steps[pollNode.x][pollNode.y] + 1;
            }

            // east
            if(pollNode.y+1 < maps[0].length && maps[pollNode.x][pollNode.y+1] == 1 && visited[pollNode.x][pollNode.y+1] != true){
                q.add(new OffsetNode(pollNode.x, pollNode.y+1));
                visited[pollNode.x][pollNode.y+1] = true;
                steps[pollNode.x][pollNode.y+1] = steps[pollNode.x][pollNode.y] + 1;
            }

        }

        return -1;
    }

}
class OffsetNode{
    int x, y;

    OffsetNode(int x, int y){
        this.x = x;
        this.y = y;
    }
}