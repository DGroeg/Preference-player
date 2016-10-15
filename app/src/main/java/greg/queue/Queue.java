package greg.queue;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Greg on 11/10/2016.
 */

public  class Queue {
    private ArrayList<ArrayList<QueueElement>> queue;

    public Queue() {
        this(10);
    }

    public Queue( int scoreNumber) {
        this(scoreNumber, null);
    }

    public Queue( int scoreNumber, ArrayList<ArrayList<QueueElement>> paramQueue) {

        if (paramQueue == null) {
            queue = new ArrayList<ArrayList<QueueElement>>();
            for (int i = 0; i <= scoreNumber; i++) {
                queue.add(new ArrayList<QueueElement>());
            }
        } else {
            queue = paramQueue;
        }
    }

    public Boolean add(QueueElement elem){
        queue.get(elem.getScore()).add(elem);
        return true;
    }

    // get the next element to play "randomly" (affected by probability)
    public QueueElement getNextMusic() {
        int score = this.getNextScore();
        int randomInt = new Random().nextInt(queue.get(score).size());
        return queue.get(score).get(randomInt);
    }

    //a refaire avec p de 1/2 à chaque classe, ptet plus rapide
    protected int getNextScore() {
        // Compute the total weight of all items together
        int totalWeight = 0;
        for( int i=0 ; i<queue.size(); i++) {
            totalWeight += queue.get(i).size() * i*i;
            // *(size-i) pour que pour 4 elements de note 4, on en a 3 de note 3 de joués
        }
        // Now choose a random int
        int randomInt = new Random().nextInt(totalWeight);
        //and get the corresponding score
        int currentScore = 0;
        for (int i=0 ; i<queue.size(); i++){
            currentScore += queue.get(i).size() * i*i;
            if ( randomInt < currentScore) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<ArrayList<QueueElement>> getQueue() { return queue; }
}
