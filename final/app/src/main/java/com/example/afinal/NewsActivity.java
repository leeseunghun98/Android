package com.example.afinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private String[] Data={"1","2"};
    private String[] Text2={"3","4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterActivity1(Data,Text2);
        recyclerView.setAdapter(adapter);
    }
}

class AdapterActivity1 extends RecyclerView.Adapter<AdapterActivity1.MainHolder> {
    private String[] Data;
    private String[] Text2;

    MainHolder mainHolder;
    // 생성자
    public AdapterActivity1(String[] Data,String[] Text2) {
        this.Data = Data;
        this.Text2 = Text2;
    }
    public static class MainHolder extends RecyclerView.ViewHolder {
        public TextView TextView_newsTextview1,TextView_newsTextview2;
        public ImageView ImageView_Newsimage1;

        public MainHolder(View v) {
            super(v);
            this.TextView_newsTextview1 = v.findViewById(R.id.TextView_newsTextview1);
            this.TextView_newsTextview2 = v.findViewById(R.id.TextView_newsTextview2);
            this.ImageView_Newsimage1 = v.findViewById(R.id.ImageView_Newsimage1);
        }
    }
    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_newsholder, parent, false);
        mainHolder = new MainHolder(holderView);
        return mainHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MainHolder mainHolder, int i) {
        mainHolder.TextView_newsTextview1.setText(this.Data[i]);
        mainHolder.TextView_newsTextview2.setText(this.Text2[i]);
    }
    @Override
    public int getItemCount() {
        return Data.length;
    }
}