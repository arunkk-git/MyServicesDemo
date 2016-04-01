package tech.sree.com.myservicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by ananth on 4/1/2016.
 */
public class MyService extends Service {

    final class MyThread implements Runnable{
        int service_id;
        MyThread(int service_id){
            this.service_id = service_id;
        }

        @Override
        public void run() {
            int i = 0;
            synchronized (this) {
                while (i++ <= 10) {
                    try {
                        wait(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf(service_id);
            }
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this,"MyService onBind ...",Toast.LENGTH_LONG).show();
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"MyService started ...",Toast.LENGTH_LONG).show();
Thread thread = new Thread(new MyThread(startId));
        thread.start();

        return START_STICKY; //super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this,"MyService onDestroy ...",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Toast.makeText(this,"MyService onCreate ...",Toast.LENGTH_LONG).show();
    }
}
