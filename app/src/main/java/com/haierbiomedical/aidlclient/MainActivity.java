package com.haierbiomedical.aidlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.haierbiomedical.deviceaidl.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {

    private IMyAidlInterface myAidlInterface;

    private boolean connected;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            connected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            connected = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindService();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String rst = myAidlInterface.openDoor(null);
                    Log.d("myac",rst);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setPackage("com.haierbiomedical.deviceaidl");
        intent.setAction("com.haierbiomedical.deviceaidl.action");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void log() {

    }

}