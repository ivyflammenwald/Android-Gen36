package com.example.dell.misintetizador_17;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {


    private Button button;
    private TextView textView;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        textView =(TextView) this.findViewById ( R.id.textView );
        button = (Button) this.findViewById ( R.id.button );
        recyclerView = (RecyclerView)  findViewById (R.id.recyclerView );

        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager (this);
        recyclerView.setLayoutManager(mLayoutManager);

        /*
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
        */


        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra ( RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM );
                intent.putExtra ( RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                try{
                    startActivityForResult (intent, 200 );
                    }catch (ActivityNotFoundException e){
                    Toast.makeText (getApplicationContext (),"Error en Intent", Toast.LENGTH_SHORT).show ();

                }
        }

    });
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult ( requestCode, resultCode, data );

        if(requestCode ==200){
            if(resultCode == RESULT_OK && data != null){
                ArrayList<String> result =data.getStringArrayListExtra ( RecognizerIntent.EXTRA_RESULTS );
                //textView.setText(result.get(0));
                mAdapter = new MyAdapter(result);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));

            }
        }
    }



    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
            private String[] mDataset;


            public class ViewHolder extends RecyclerView.ViewHolder {

                public TextView mTextView;
                public ViewHolder(TextView v) {
                    super(v);
                    mTextView = v;
                }
            }

            // Provide a suitable constructor (depends on the kind of dataset)
            public MyAdapter(ArrayList<String> myDataset) {
                mDataset = myDataset.toArray ( new String[0] );
            }

            // Create new views (invoked by the layout manager)
            @Override
            public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                Context context = parent.getContext();
                LayoutInflater inflater = LayoutInflater.from(context);

                // Inflate the custom layout
                View fraseView = inflater.inflate(R.layout.item_frase, parent, false);

                // Return a new holder instance
                ViewHolder viewHolder = new ViewHolder( (TextView) fraseView );
                return viewHolder;
            }


        // Replace the contents of a view (invoked by the layout manager)
            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                // - get element from your dataset at this position
                // - replace the contents of the view with that element
                holder.mTextView.setText(mDataset[position]);

            }

            // Return the size of your dataset (invoked by the layout manager)
            @Override
            public int getItemCount() {
                return mDataset.length;
            }
        }
    }
