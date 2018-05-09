package com.example.dell.myasynctask_17;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    String url = "https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.HcXlI9uQChH1qDjc_dP36wHaFj%26pid%3D15.1&f=1";
    ImageView imageView;
    Button button;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        imageView = (ImageView) findViewById ( R.id.imageView );
        button = (Button) findViewById ( R.id.button );
        progressBar = (ProgressBar) findViewById ( R.id.progressBar );
        MyAsink miasink = (MyAsink) new MyAsink (progressBar).execute("");



    }



    private class MyAsink extends AsyncTask {

        public ProgressBar pb;

        public MyAsink(ProgressBar pb) {
            this.pb = pb;
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            for(int i =0; i<100; i++){
                progressBar.setProgress ( i+1 );

            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute ( o );
            loadImageFromUrl ( url );
        }

        private void loadImageFromUrl(String url) {
            Picasso.get().load(url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView);

        }
    }
}