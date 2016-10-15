package greg.queue;

/**
 * Created by Greg on 11/10/2016.
 */

public class QueueElement {

    private double id;
    private int score;
    private double length; //in seconds

    public QueueElement(double paramId, int paramScore, double paramLength){
        id = paramId;
        score = paramScore;
        length = paramLength;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() { return score; }
    public double getId() { return id; }
    public double getLength() { return length; }
}
