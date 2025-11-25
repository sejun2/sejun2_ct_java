import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Task> pq = new PriorityQueue<Task>();
        
        Arrays.sort(jobs, (a, b) -> { return a[0] - b[0]; });
        
        int i = 0;
        int answer = 0;
        int count =0;
      
        while(pq.isEmpty()){
            i = jobs[0][0];
            for(int k =0; k < jobs.length; k++){
        		if(jobs[k][0] == i) {
                    pq.add(new Task(k, jobs[k][0], jobs[k][1]));
                    count++;
                }
            }
        }
        
        while(!pq.isEmpty()){
            Task item = pq.poll();
            
            if(i <= item.requestTime){
            	i = item.requestTime;
            }
            System.out.println("item" + item.number +" currentTime : "+i);
        
            i = i+item.duration;
            
        	for(int k = count; k<jobs.length; k++)    {
                if(jobs[k][0] <= i){
                    pq.add(new Task(k, jobs[k][0], jobs[k][1]));
                    count++;
                }
            }
            
            if(count != jobs.length && pq.isEmpty()){
                pq.add(new Task(count, jobs[count][0], jobs[count][1]));
            	count++;
            }
            
            answer += i - item.requestTime;
            
        }
        
        return (int) (answer / jobs.length);
    }
}

class Task implements Comparable<Task> {
   
    int number;
    int requestTime;
    int duration;
    
    public Task(int num, int req, int dur){
        this.number = num;
       	this.requestTime = req; 
        this.duration = dur;
    }
    
   
    @Override
    public int compareTo(Task o){
        if(this.duration > o.duration){
            return 1;
        }else if(this.duration < o.duration){
            return -1;
        }
        
        if(this.requestTime > o.requestTime){
            return 1;
        }else if(this.requestTime < o.requestTime){
            return -1;
        }
        
        if(this.number > o.number) {
            return 1;
        }else if(this.number < o.number){
            return -1;
        }
        
        return 0;
    }
    
}