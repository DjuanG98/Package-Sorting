package com.maddtech.packagesorting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InfoActivity extends AppCompatActivity {

    EditText barcode, name, email, location, td, shipper;
    EditText et;
    DatabaseReference mDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        barcode = findViewById(R.id.et_Barcode);
        name = findViewById(R.id.et_Name);
        email = findViewById(R.id.et_Email);
        location = findViewById(R.id.et_Location);
        td = findViewById(R.id.et_TD);
        shipper = findViewById(R.id.et_Shipper);
        Intent intent = getIntent();
        String barcode1 = intent.getStringExtra("Barcode");
        String text1 = intent.getStringExtra("Text");

        barcode.setText(barcode1);

        final GestureDetector gestureDetector = new GestureDetector(InfoActivity.this,new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent e) {
                // start activity
                return true;
            }
        });


    }

    public class Entry{

        private String Name;
        private String Tracking_ID;
        private String Location;

        public Entry(){
        }

        public Entry(String Name, String Tracking_ID, String Location){
            this.Name=Name;
            this.Tracking_ID=Tracking_ID;
            this.Location=Location;
        }
        public String getName(){
            return Name;
        }
        public void setName(String Name){
            this.Name = Name;
        }
        public String getTracking(){
            return Tracking_ID;
        }
        public void setTracking(String Tracking_ID){
            this.Tracking_ID = Tracking_ID;
        }
        public String getLocation(){
            return Location;
        }
        public void setLocation(String Location){
            this.Location = Location;
        }
    }

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();

    public void save(View view){
        String Barcode = barcode.getText().toString();
        String Name = name.getText().toString();
        String Location = location.getText().toString();
        Entry entry = new Entry(Name,Barcode,Location);
        mDbRef = database.getReference().child("Student").child(Name);
        mDbRef.setValue(entry);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
