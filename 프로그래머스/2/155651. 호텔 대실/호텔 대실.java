import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int max = 0;
      
        ArrayList<Node> list = new ArrayList<>();
        
        ArrayList<Room> roomPool = new ArrayList<>();
       
        for(String[] data: book_time){
            String[] spl1 = data[0].split(":");
            Time startTime = new Time(Integer.parseInt(spl1[0]), Integer.parseInt(spl1[1]));
            
            String[] spl2 = data[1].split(":");
            Time endTime = new Time(Integer.parseInt(spl2[0]), Integer.parseInt(spl2[1]));
            
            Node node = new Node(startTime, endTime);
            list.add(node);
        }
        
        // sort by start time
        Collections.sort(list);
        
        while(!list.isEmpty()){
     
            Node n = list.get(0);
            list.remove(0);
            
            Room r = getAvailableRoom(roomPool, n);
        }
        
       return roomPool.size(); 
    }
    
    Room getAvailableRoom(ArrayList<Room> pool, Node curr){
            for(Room r : pool){
                if(r.endTime.hour < curr.start.hour){
                    r.update(curr);
                    return r;
                }
                if(r.endTime.hour == curr.start.hour){
                    if(r.endTime.min <= curr.start.min){
                    r.update(curr);
                        return r;
                    }
                }
            }
        
            Room newRoom = new Room(new Node(new Time(curr.start.hour,curr.start.min), new Time(curr.end.hour,curr.end.min)));
        pool.add(newRoom);
        
        return newRoom;
    }
}

class Node implements Comparable<Node>{
    Time start, end;
    Node(Time start, Time end){
        this.start = start;
        this.end = end;
    }
   
    @Override
    public int compareTo(Node n){
        if(this.start.hour != n.start.hour){
            return this.start.hour - n.start.hour;
        }else{
            return this.start.min - n.start.min;
        }
    }
}

class Time {
    int hour, min;
    
    Time(int hour, int min){
        this.hour = hour;
        this.min = min;
    }
}

class Room {
    Node n;
    Time endTime;
    
    Room(Node n){
        this.n = n;
      
        Time t = new Time(n.end.hour,n.end.min);
        
        if(n.end.min + 10 >=60){
           t.hour += 1; 
            t.min = n.end.min+10 - 60;
        }else{
            t.min += 10;
        }
        
        this.endTime = t;
    }
    
    void update(Node n){
        this.n = n;
        
        Time t = new Time(n.end.hour,n.end.min);
        
        if(n.end.min + 10 >=60){
           t.hour += 1; 
            t.min = n.end.min+10 - 60;
        }else{
            t.min += 10;
        }
        
        this.endTime = t;
    }
}