package com.example.bartek.androidtutorial;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           }

    public void btnClick(final View view) {
        AlertDialog.Builder alertD = new AlertDialog.Builder(this);
        alertD.setMessage("Are you sure? ");
        alertD.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                EditText editText = (EditText) findViewById(R.id.edit);
                String string = String.valueOf(editText.getText());

                intent.putExtra(SecondActivity.KEY, string);

                startActivity(intent);

            }
        });
        alertD.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertD.show();
    }

    public void nClick(View view) {
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent intent= new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,intent,0 );

        Notification.Builder notificationBuilder= new Notification.Builder(this)
                .setSmallIcon(android.R.drawable.ic_menu_zoom)
                .setContentTitle("NOTYFIKACJA")
                .setContentText("This is content ...")
                .setContentIntent(pendingIntent);

        Notification notification = notificationBuilder.build();

        notificationManager.notify(0, notification);

    }
}

