package com.example.simpleasynchtask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

    private WeakReference<TextView> mTextView;

    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {
        int sleep = new Random().nextInt(11) * 200;
        try{
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("Awake at last after sleeping for %s milliseconds!", sleep);
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
