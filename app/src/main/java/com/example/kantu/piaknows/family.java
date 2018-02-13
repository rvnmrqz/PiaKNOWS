package com.example.kantu.piaknows;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class family extends AppCompatActivity {

    Button a, b, c, d, e, f, g;

    public void la()
    {
        a = (Button) findViewById(R.id.aaaaaaaaaaaaa);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(family.this, fama.class);
                startActivity(a);
            }
        });
    }
    public void le()
    {
        b = (Button) findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(family.this, famb.class);
                startActivity(b);
            }
        });
    }

    public void li()
    {
        c = (Button) findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(family.this, famc.class);
                startActivity(c);
            }
        });
    }

    public void lo()
    {
        d = (Button) findViewById(R.id.d);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(family.this, famd.class);
                startActivity(d);
            }
        });
    }

    public void lu()
    {
        e = (Button) findViewById(R.id.e);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(family.this, fame.class);
                startActivity(e);
            }
        });
    }

    public void ka()
    {
        f = (Button) findViewById(R.id.f);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(family.this, famf.class);
                startActivity(f);
            }
        });
    }

    public void ke()
    {
        g = (Button) findViewById(R.id.g);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(family.this, famg.class);
                startActivity(g);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        la();
        le();
        li();
        lo();
        lu();
        ka();
        ke();
    }
}
