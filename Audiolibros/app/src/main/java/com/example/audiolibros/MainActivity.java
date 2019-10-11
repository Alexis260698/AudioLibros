package com.example.audiolibros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Aplicacion app=(Aplicacion) getApplication();
        recyclerView=(RecyclerView) findViewById(R.id.reycler_view);
        recyclerView.setAdapter(app.getAdaptador());
        layoutManager=new GridLayoutManager(this,2,
                LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        app.getAdaptador().setOnItemClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
                Toast.makeText(MainActivity.this,"Seleccionado el elemento:"
                + recyclerView.getChildAdapterPosition(v),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
