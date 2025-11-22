class Solution {
    int[][] dxdy = new int[][] {
    	new int[] {1, 0},
    	new int[] {0, 1},
    	new int[] {-1,0},
    	new int[] {0,-1}
    };
    
    int answer = 9999999;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[102][102];
        
        for(int i =0 ;i<rectangle.length;i++){
            rectangle[i][0] *=2;	
            rectangle[i][1] *=2;
            rectangle[i][2] *=2;	
            rectangle[i][3] *=2;
        }
        
        characterX *= 2;
        characterY *= 2;
        
        itemX *=2;
        itemY *=2;
        
        dfs(rectangle, characterX, characterY, itemX, itemY, visited, 0);
        
        return answer/2;
    }
    
    void dfs(int[][] rectangle, int characterX, int characterY, int itemX, int itemY, boolean[][] visited, int count){
        
        
        if(characterX == itemX && characterY == itemY){
            answer = Math.min(answer, count);
            return;
        }
        
        visited[characterX][characterY] = true;
        
        
        if(!isBorder(rectangle, characterX, characterY)){
            return;
        }
        
        if(isInside(rectangle, characterX, characterY)){
            return;
        }
        
        System.out.println(characterX +"  "+characterY);
        
        for(int i =0;i<dxdy.length;i++){
            if(visited[characterX+dxdy[i][0]][characterY+dxdy[i][1]]) continue;
        //if(!canGo(rectangle, characterX, characterY, characterX+dxdy[i][0], characterY+dxdy[i][1])) continue;
           dfs(rectangle, characterX+dxdy[i][0], characterY+dxdy[i][1], itemX, itemY, visited, count+1) ;
        }
    }
    
    boolean isBorder(int[][] rectangle, int x, int y){
       for(int i =0; i<rectangle.length; i++) {
           int minX = rectangle[i][0];
           int maxX = rectangle[i][2];
           int minY = rectangle[i][1];
           int maxY = rectangle[i][3];
           
           if(x == minX || x == maxX){
               if(y >= minY && y <=maxY){
                   return true;
               }
           }else if(x>=minX && x <=maxX){
               if(y == minY || y == maxY){
                   return true;
               }
           }
       }
        
        return false;
    }
    
    boolean isBorder(int[] rectangle, int x, int y){
           int minX = rectangle[0];
           int maxX = rectangle[2];
           int minY = rectangle[1];
           int maxY = rectangle[3];
           
           if(x == minX || x == maxX){
               if(y >= minY && y <=maxY){
                   return true;
               }
           }else if(x>=minX && x <=maxX){
               if(y == minY || y == maxY){
                   return true;
               }
           }
        
        return false;
    }
    
    boolean isInside(int[][] rectangle, int x, int y){
       for(int i =0; i<rectangle.length; i++) {
           int minX = rectangle[i][0];
           int maxX = rectangle[i][2];
           int minY = rectangle[i][1];
           int maxY = rectangle[i][3];
           
           if(x > minX && x < maxX){
               if(y > minY && y <maxY){
                   return true;
               }
           }
       }
        
        return false;
    }
    
    boolean canGo(int[][] rectangle, int fromX, int fromY, int toX, int toY){
        if(toX >50 || toY >50) return false;
        
       for(int i =0; i<rectangle.length; i++) {
           int minX = rectangle[i][0];
           int maxX = rectangle[i][2];
           int minY = rectangle[i][1];
           int maxY = rectangle[i][3];
           
           if(!isBorder(rectangle[i], fromX, fromY)) continue;
           if(!isBorder(rectangle[i], toX, toY)) continue;
          
           if(fromX == toX){
               if(maxY - minY ==1){
                   if(fromX != minX && fromX != maxX){
                       return false;
                   }
               }
           }
           
           if(fromY == toY){
               if(maxX - minX == 1){
                   if(fromY != minY && fromY != maxY){
                       return false;
                   }
               }
           }
       }
        
        return true;
    }
}