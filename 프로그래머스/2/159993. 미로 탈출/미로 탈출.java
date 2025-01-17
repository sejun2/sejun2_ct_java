import java.util.*;

class Solution {
    public int solution(String[] maps) {
        String[][] arr = new String[maps.length][maps[0].length()];
        Boolean[][] visited = new Boolean[maps.length][maps[0].length()];
       
        int startX = 0;
        int startY = 0;
        
        int leverX = 0;
        int leverY = 0;
        
        int endX = 0;
        int endY = 0;
        
		for(int i =0 ;i<maps.length;i++)   {
            for(int j = 0; j<maps[0].length();j++){
                arr[i][j] = Character.toString(maps[i].charAt(j));
                visited[i][j] = false;
                
                if(arr[i][j].equals("S")){
                    startX = i;
                    startY = j;
                }
                
                if(arr[i][j].equals("L")){
                    leverX = i; 
                    leverY = j;
                }
                
                if(arr[i][j].equals("E")){
                    endX = i;
                    endY = j;
                }
            }
        }
        
        int res =  bfs(visited, arr,  new Point(startX, startY, 0), new Point(leverX, leverY, 0), new Point(endX, endY, 0));
        
        if(res == 0) return -1;
        return res;
    }
    
    int bfs(Boolean[][] visited, String[][] arr, Point p, Point lever, Point end){
        Queue<Point> q = new LinkedList<>();
        
        q.add(p);
        visited[p.x][p.y] = true;
        
        // 상 하 좌 우
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        
        int depth = 0;
        
        while(!q.isEmpty()){
            Point polled = q.poll(); 
            
            depth = polled.depth;
            
            if(arr[polled.x][polled.y].equals("L")) {
                break;
            }
           
            
            for(int i = 0; i<4;i++) {
                if(canGo(new Point(polled.x + dx[i], polled.y + dy[i], depth+1), arr, visited)) {
                    q.add(new Point(polled.x + dx[i], polled.y + dy[i], depth+1));
                    visited[polled.x + dx[i]][polled.y + dy[i]] = true;
                }
            }
        }
        
        
        if(visited[lever.x][lever.y] == false){
            return 0;
        }
       
         // 방문 배열 초기화
        for(Boolean[] v : visited) {
            Arrays.fill(v, false);
        }
        
        q.clear();
        q.add(new Point(lever.x, lever.y, depth));
        visited[lever.x][lever.y] = true;
        
        while(!q.isEmpty()){
            Point polled = q.poll(); 
            
            depth = polled.depth;
            
            if(arr[polled.x][polled.y].equals("E")) {
                break;
            }
            
            
            for(int i = 0; i<4;i++) {
                if(canGo(new Point(polled.x + dx[i], polled.y + dy[i], depth+1), arr, visited)) {
                    q.add(new Point(polled.x + dx[i], polled.y + dy[i], depth+1));
                    visited[polled.x + dx[i]][polled.y + dy[i]] = true;
                }
            }
        }
        
        if(visited[end.x][end.y] == false){
            return 0;
        }
        
        
        return depth;
    }
    
    Boolean canGo(Point p, String[][] arr, Boolean[][] visited){
       if(p.x < 0 || p.x >= arr.length){
           return false;
       }
        
        if(p.y <0 || p.y >= arr[0].length){
            return false;
        }
        
        if(arr[p.x][p.y].equals("X")){
            return false;
        }
        
       if(visited[p.x][p.y] == true) {
           return false;
       }
        
        return true;
    }
}

class Point {
    int x, y, depth;
    
    Point(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}