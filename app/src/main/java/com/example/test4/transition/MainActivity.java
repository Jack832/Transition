package com.example.test4.transition;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity implements View.OnClickListener {
    private ViewGroup mrootview;
    private View redb,greenb,blackb,buleb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mrootview=(ViewGroup)findViewById(R.id.layout_root_view);
        mrootview.setOnClickListener(this);
        redb=findViewById(R.id.red);
        greenb=findViewById(R.id.green);
        blackb=findViewById(R.id.black);
        buleb=findViewById(R.id.blue);
    }

    @Override
    public void onClick(View v) {
        TransitionManager.beginDelayedTransition(mrootview,new Explode());
        toggleVisibility(redb,greenb,buleb,blackb);
    }

    private static void toggleVisibility(View...views) {
        for(View view:views)
        {
            boolean isVisible = view.getVisibility() ==View.VISIBLE;
            view.setVisibility(isVisible ? View.INVISIBLE :View.VISIBLE);

        }
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
