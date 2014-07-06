package com.sit.progresbar_asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MyActivity extends Activity {
    private TextView status;
    protected Button btn;
    protected ProgressBar progressBar;
    protected int tmp=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        status = (TextView) findViewById(R.id.status);
        btn = (Button) findViewById(R.id.startbtn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);

    }
    public void ClickBtn(View v) {
        tmp=0;
        new MyAsynctask().execute();
        btn.setText("Restart now");

    }

    class MyAsynctask extends AsyncTask<Void, Integer, Void> {


        @Override
        protected Void doInBackground(Void... params) {
            while (tmp < 100) {
                tmp++;
                publishProgress(tmp);
                SystemClock.sleep(1000);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            status.setText(String.valueOf(values[0] + "%"));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            btn.setText("Restart now");
        }
    }
}
