package naresh.mrj.com.animationscrool;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    CoordinatorLayout coordinateLayout;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinateLayout=(CoordinatorLayout)findViewById(R.id.coordinateLayout);
        floatingActionButton=(FloatingActionButton)findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinateLayout,"THis is Me Naresh Palyer One",Snackbar.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,RippleActivity.class));
            }
        });
    }
}
