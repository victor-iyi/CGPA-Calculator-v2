package com.victoriyiola.cgpacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

import com.victoriyiola.cgpacalculator.helpers.InputHelper;
import com.victoriyiola.cgpacalculator.helpers.Message;

import java.util.Locale;

public class Homepage extends AppCompatActivity implements View.OnClickListener {

    private TextView resultCGPA, resultGPA;
    private static final int minCourses = 1, maxCourses = 20;
    private static final int minSemesters = 1, maxSemesters = 12;
    // GPA Buttons
    private Button zeroGPA, oneGPA, twoGPA, threeGPA, fourGPA,
        fiveGPA, sixGPA, sevenGPA, eightGPA, nineGPA, backGPA, submitGPA;
    // CGPA Buttons
    private Button zeroCGPA, oneCGPA, twoCGPA, threeCGPA, fourCGPA,
        fiveCGPA, sixCGPA, sevenCGPA, eightCGPA, nineCGPA, backCGPA, submitCGPA;
    private InputHelper inputHelperGPA, inputHelperCGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavDrawerFragment drawerFragment = (NavDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment.setup(drawerLayout, toolbar, R.id.fragment_navigation_drawer);

        // Setup TabView
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        // GPA Tab
        TabHost.TabSpec specGPA = tabHost.newTabSpec("gpa_tag");
        specGPA.setContent(R.id.tabGPA);
        specGPA.setIndicator("GPA");
        tabHost.addTab(specGPA);
        // CGPA Tab
        TabHost.TabSpec specCGPA = tabHost.newTabSpec("cgpa_tag");
        specCGPA.setContent(R.id.tabCGPA);
        specCGPA.setIndicator("CGPA");
        tabHost.addTab(specCGPA);

        // initialize variables
        initVars();
    }

    // Helper functions
    private void initVars() {
        // GPA Vars
        resultGPA = (TextView) findViewById(R.id.tvResultGPA);
        zeroGPA = (Button) findViewById(R.id.b0GPA); oneGPA = (Button) findViewById(R.id.b1GPA);
        twoGPA = (Button) findViewById(R.id.b2GPA); threeGPA = (Button) findViewById(R.id.b3GPA);
        fourGPA = (Button) findViewById(R.id.b4GPA); fiveGPA = (Button) findViewById(R.id.b5GPA);
        sixGPA = (Button) findViewById(R.id.b6GPA); sevenGPA = (Button) findViewById(R.id.b7GPA);
        eightGPA = (Button) findViewById(R.id.b8GPA); nineGPA = (Button) findViewById(R.id.b9GPA);
        backGPA = (Button) findViewById(R.id.bBackGPA); submitGPA = (Button) findViewById(R.id.bSubmitGPA);
        inputHelperGPA = new InputHelper(resultGPA);

        // CGPA Vars
        resultCGPA = (TextView) findViewById(R.id.tvResultCGPA);
        zeroCGPA = (Button) findViewById(R.id.b0CGPA); oneCGPA = (Button) findViewById(R.id.b1CGPA);
        twoCGPA = (Button) findViewById(R.id.b2CGPA); threeCGPA = (Button) findViewById(R.id.b3CGPA);
        fourCGPA = (Button) findViewById(R.id.b4CGPA); fiveCGPA = (Button) findViewById(R.id.b5CGPA);
        sixCGPA = (Button) findViewById(R.id.b6CGPA); sevenCGPA = (Button) findViewById(R.id.b7CGPA);
        eightCGPA = (Button) findViewById(R.id.b8CGPA); nineCGPA = (Button) findViewById(R.id.b9CGPA);
        backCGPA = (Button) findViewById(R.id.bBackCGPA); submitCGPA = (Button) findViewById(R.id.bSubmitCGPA);
        inputHelperCGPA = new InputHelper(resultCGPA);
        setOnClicks();
    }
    private void setOnClicks() {
        // GPA OnClicks
        zeroGPA.setOnClickListener(this); oneGPA.setOnClickListener(this);
        twoGPA.setOnClickListener(this); threeGPA.setOnClickListener(this);
        fourGPA.setOnClickListener(this); fiveGPA.setOnClickListener(this);
        sixGPA.setOnClickListener(this); sevenGPA.setOnClickListener(this);
        eightGPA.setOnClickListener(this); nineGPA.setOnClickListener(this);
        backGPA.setOnClickListener(this); submitGPA.setOnClickListener(this);

        // CGPA OnClicks
        zeroCGPA.setOnClickListener(this); oneCGPA.setOnClickListener(this);
        twoCGPA.setOnClickListener(this); threeCGPA.setOnClickListener(this);
        fourCGPA.setOnClickListener(this); fiveCGPA.setOnClickListener(this);
        sixCGPA.setOnClickListener(this); sevenCGPA.setOnClickListener(this);
        eightCGPA.setOnClickListener(this); nineCGPA.setOnClickListener(this);
        backCGPA.setOnClickListener(this); submitCGPA.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            // GPA Events
            case R.id.b0GPA: inputHelperGPA.appendToResult(zeroGPA.getText().toString()); break;
            case R.id.b1GPA: inputHelperGPA.appendToResult(oneGPA.getText().toString()); break;
            case R.id.b2GPA: inputHelperGPA.appendToResult(twoGPA.getText().toString()); break;
            case R.id.b3GPA: inputHelperGPA.appendToResult(threeGPA.getText().toString()); break;
            case R.id.b4GPA: inputHelperGPA.appendToResult(fourGPA.getText().toString()); break;
            case R.id.b5GPA: inputHelperGPA.appendToResult(fiveGPA.getText().toString()); break;
            case R.id.b6GPA: inputHelperGPA.appendToResult(sixGPA.getText().toString()); break;
            case R.id.b7GPA: inputHelperGPA.appendToResult(sevenGPA.getText().toString()); break;
            case R.id.b8GPA: inputHelperGPA.appendToResult(eightGPA.getText().toString()); break;
            case R.id.b9GPA: inputHelperGPA.appendToResult(nineGPA.getText().toString()); break;
            case R.id.bBackGPA: inputHelperGPA.deleteLastCharacter(); break;
            case R.id.bSubmitGPA:
                int noOfCourses = Integer.parseInt(resultGPA.getText().toString());
                if (noOfCourses < minCourses || noOfCourses > maxCourses)
                    Message.show(Homepage.this, "Number of courses out of range",
                            String.format(Locale.getDefault(),
                                    "Minimum number of Courses:\t%d\nMaximum number of Courses:\t%d\n",
                                    minCourses, maxCourses));
                else {
                    Bundle basket = new Bundle();
                    basket.putInt("noOfCourses", noOfCourses);
                    Intent intent = new Intent(Homepage.this, CalculateGPA.class);
                    intent.putExtras(basket);
                    startActivity(intent);
                }
                break;

            // CGPA Events
            case R.id.b0CGPA: inputHelperCGPA.appendToResult(zeroCGPA.getText().toString()); break;
            case R.id.b1CGPA: inputHelperCGPA.appendToResult(oneCGPA.getText().toString()); break;
            case R.id.b2CGPA: inputHelperCGPA.appendToResult(twoCGPA.getText().toString()); break;
            case R.id.b3CGPA: inputHelperCGPA.appendToResult(threeCGPA.getText().toString()); break;
            case R.id.b4CGPA: inputHelperCGPA.appendToResult(fourCGPA.getText().toString()); break;
            case R.id.b5CGPA: inputHelperCGPA.appendToResult(fiveCGPA.getText().toString()); break;
            case R.id.b6CGPA: inputHelperCGPA.appendToResult(sixCGPA.getText().toString()); break;
            case R.id.b7CGPA: inputHelperCGPA.appendToResult(sevenCGPA.getText().toString()); break;
            case R.id.b8CGPA: inputHelperCGPA.appendToResult(eightCGPA.getText().toString()); break;
            case R.id.b9CGPA: inputHelperCGPA.appendToResult(nineCGPA.getText().toString()); break;
            case R.id.bBackCGPA: inputHelperCGPA.deleteLastCharacter(); break;
            case R.id.bSubmitCGPA:
                int noOfSemesters = Integer.parseInt(resultCGPA.getText().toString());
                if (noOfSemesters < minSemesters || noOfSemesters > maxSemesters)
                    Message.show(Homepage.this, "Number of semesters out of range",
                            String.format(Locale.getDefault(),
                                    "Minimum number of Semesters:\t%d\nMaximum number of Semesters:\t%d\n",
                                    minSemesters, maxSemesters));
                else {
                    Bundle basket = new Bundle();
                    basket.putInt("noOfSemesters", noOfSemesters);
                    Intent intent = new Intent(Homepage.this, CalculateCGPA.class);
                    intent.putExtras(basket);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
