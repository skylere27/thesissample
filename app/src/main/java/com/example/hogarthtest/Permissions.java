package com.example.hogarthtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Permissions extends AppCompatActivity {

    Button hide;
    Button show;
    TextView permText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hide = findViewById(R.id.hide);
        hide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hide(v);
            };
        });

        show = findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                show(v);
            };
        });

        permText = findViewById(R.id.perm);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // figure out something to do with this
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void hide(View view) {
        // disables hide button (view)
        hide.setEnabled(false);
        show.setEnabled(true);
        // hides the permission text
        permText.setVisibility(View.INVISIBLE);
    }

    public void show(View view) {
        // disables show button (view)
        show.setEnabled(false);
        hide.setEnabled(true);
        // hides the permission text
        permText.setVisibility(View.VISIBLE);
    }

}
