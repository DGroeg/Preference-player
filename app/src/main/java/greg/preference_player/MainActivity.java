package greg.preference_player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import greg.queue.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Queue queue = new Queue(4);
        QueueElement q1 = new QueueElement(1, 4, 123);
        QueueElement q2 = new QueueElement(2, 3, 1489);
        QueueElement q3 = new QueueElement(3, 2, 59);
        QueueElement q4 = new QueueElement(4, 1, 148);
        QueueElement q5 = new QueueElement(1, 0, 14);
        queue.add(q1);
        queue.add(q2);
        queue.add(q3);
        queue.add(q4);
        queue.add(q5);

        int[] array = new int[5];
        for (int i=0; i < 1000; i++){
            QueueElement next = queue.getNextMusic();
            array[next.getScore()] += 1;
        }
        Log.w("myTag","ID4 :" + array[4]);
        Log.w("myTag","ID3 :" + array[3]);
        Log.w("myTag","ID2 :" + array[2]);
        Log.w("myTag","ID1 :" + array[1]);
        Log.w("myTag","ID0 : " + array[0]);
        setContentView(R.layout.activity_main);
    }
}
