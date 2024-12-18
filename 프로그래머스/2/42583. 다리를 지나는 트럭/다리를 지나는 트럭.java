import java.util.*;


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> q = new LinkedList<>();
        int seconds = 0;
        int currentWeight = 0;
        ArrayList<Truck> truckList = new ArrayList<>();
        for (int w : truck_weights) {
            truckList.add(new Truck(w, 0));
        }
        
                Truck first = truckList.get(0);
        first.position = -1;
                    truckList.remove(0);
                    q.add(first);
                    currentWeight += first.weight;

        while (!q.isEmpty()) {
            for (Truck qt : q) {
                qt.position = qt.position + 1;
            }
           
                
            Truck peeked = q.peek();
            if (peeked.position >= bridge_length) {
                Truck tPolled = q.poll();
                currentWeight -= tPolled.weight;
            }

            if (!truckList.isEmpty() && q.size() < bridge_length) {
                Truck t = truckList.get(0);
                if (t.weight + currentWeight <= weight) {
                    truckList.remove(0);
                    q.add(t);
                    currentWeight += t.weight;
                }
            }

            
                seconds++;
        }

        return seconds;
    }
}

class Truck {
    int weight;
    int position;

    public Truck(int w, int p) {
        this.weight = w;
        this.position = p;
    }

    @Override
    public String toString() {
        return weight + " :: " + position;
    }
}