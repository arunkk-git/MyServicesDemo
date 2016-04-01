package tech.sree.com.myservicesdemo;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ananth on 4/1/2016.
 */
public class MyserviceIntent extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyserviceIntent() {
        super("MyAutoWorkerThread");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Toast.makeText(this, "MyService onHandleIntent ...", Toast.LENGTH_LONG).show();
        int i = 0;
        synchronized (this) {
            while (i++ <= 10) {
                try {
                    wait(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
           // stopSelf(service_id); // NOT REQUIRED
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"MyService onStartCommand ...",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"MyService onDestroy ...",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}
