package com.android.attendance.activity;

import com.android.attendance.bean.StudentBean;
import com.android.attendance.db.DBAdapter;
import com.example.androidattendancesystem.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
package com.eddrix.project.evoting.activities;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eddrix.project.evoting.R;
import com.eddrix.project.evoting.adapters.ElectionCandidatesAdpater;
import com.eddrix.project.evoting.design.Space;
import com.eddrix.project.evoting.models.ElectionCandidates;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ElectedCandidatesActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= 23) {


            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);



        }else if(Build.VERSION.SDK_INT<22){
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));

        }
        setContentView(R.layout.activity_elected_candidates);

        toolbar=findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.RecyclerView);
        toolbar.setTitle("Select Party");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(view -> finish());


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<ElectionCandidates> homeProjectsPostModelList=new ArrayList<>();

        homeProjectsPostModelList.add(new ElectionCandidates(1,"Janasena Party","Pavan Kalyan",R.drawable.janasena,"some description here we shall put"));
        homeProjectsPostModelList.add(new ElectionCandidates(2,"BJP Party","Pavan Kalyan",R.drawable.bjp,"some description here we shall put"));
        homeProjectsPostModelList.add(new ElectionCandidates(3,"Congress Party","Pavan Kalyan",R.drawable.congress,"some description here we shall put"));
        homeProjectsPostModelList.add(new ElectionCandidates(4,"Telugu Desam Party","Pavan Kalyan",R.drawable.telugu,"some description here we shall put"));
        homeProjectsPostModelList.add(new ElectionCandidates(5,"CPI Party","Pavan Kalyan",R.drawable.cpi,"some description here we shall put"));
        homeProjectsPostModelList.add(new ElectionCandidates(6,"Janasena Party","Pavan Kalyan",R.drawable.janasena,"some description here we shall put"));

        ElectionCandidatesAdpater projectRecyclerView=new
                ElectionCandidatesAdpater(homeProjectsPostModelList,this);

        recyclerView.addItemDecoration(new Space(1,20,true,0));
        recyclerView.setAdapter(projectRecyclerView);

    }




}
