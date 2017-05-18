package com.victoriyiola.cgpacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class AboutPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_page);

        // Toolbar setup
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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

        switch (id) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menuAbout:
                Intent about = new Intent(getApplicationContext(), AboutPage.class);
                startActivity(about);
                break;

            case R.id.menuSavedGPAs:
                Intent savedGPs = new Intent(getApplicationContext(), SavedGPA.class);
                startActivity(savedGPs);
                break;

            case R.id.menuSavedCGPAs:
                Intent gpa = new Intent(getApplicationContext(), SavedCGPA.class);
                startActivity(gpa);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}