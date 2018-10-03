package com.example.nguyenhuutu.convenientmenu;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.addDish).setOnClickListener(this);
        findViewById(R.id.loadAllDish).setOnClickListener(this);
        findViewById(R.id.loadDish).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addDish) {
            List<String> imgs = Arrays.asList("dish01.jpg", "dish02.jpg");
            //Dish newDish = new Dish("","dish 01",30000, "dish 01 01","dish01.jpg", imgs, "MENU001", "DTYPE01");

//            if(newDish.addDish() == TRUE) {
//                Toast.makeText(MainActivity.this, "Add dish success", Toast.LENGTH_SHORT).show();
//            }
//            else {
//                Toast.makeText(MainActivity.this, Dish.errorLog, Toast.LENGTH_LONG).show();
//            }
            CMDB.db.collection("Dish").document("DISH0")
                    .set(Dish.createDishData("","dish 01",30000, "dish 01 01","dish01.jpg", imgs, "MENU001", "DTYPE01"))
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Button btn = (Button)findViewById(R.id.addDish);
                            btn.setText("welcome");
                            Toast.makeText(MainActivity.this, "Add success", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });

        }
        if (v.getId() == R.id.loadAllDish) {

        }
        if (v.getId() == R.id.loadDish) {

        }
    }
}
