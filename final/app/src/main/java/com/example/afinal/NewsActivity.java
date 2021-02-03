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
    private String[] Title={"1","2"};
    private String[] Content={"3","4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterActivity1(Title,Content);
        recyclerView.setAdapter(adapter);
    }
}

class AdapterActivity1 extends RecyclerView.Adapter<AdapterActivity1.MainHolder> {
    private String[] Title;
    private String[] Content;

    MainHolder mainHolder;
    // 생성자
    public AdapterActivity1(String[] Title,String[] Content) {
        this.Title = Title;
        this.Content = Content;
    }
    public static class MainHolder extends RecyclerView.ViewHolder {
        public TextView TextView_newsTitle,TextView_newsContent;
        public ImageView ImageView_News_img;

        public MainHolder(View v) {
            super(v);
            this.TextView_newsTitle = v.findViewById(R.id.TextView_newsTitle);
            this.TextView_newsContent = v.findViewById(R.id.TextView_newsContent);
            this.ImageView_News_img = v.findViewById(R.id.ImageView_News_img);
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
        mainHolder.TextView_newsTitle.setText(this.Title[i]);
        mainHolder.TextView_newsContent.setText(this.Content[i]);
    }
    @Override
    public int getItemCount() {
        return Title.length;
    }
}