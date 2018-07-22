package naresh.mrj.com.animationscrool;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SharedElementActivity extends AppCompatActivity {


    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);

        initPage();
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }
        return true;
    }

    private void initPage()
    {

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shared Element Transition");

        relativeLayout= findViewById(R.id.relative_layout);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
               makeCircularRevealAnimation(relativeLayout);
            }
        });

        Button backButton=findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                }
            }
        });



    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void makeCircularRevealAnimation(View view )
    {

        final TextView circularTest=findViewById(R.id.circular_test);


        int centerX=(view.getLeft()+view.getRight())/2;
        int centerY=(view.getTop()+view.getBottom())/2;

        float radius=Math.max(circularTest.getWidth(),circularTest.getHeight())*2.0f;


        if (circularTest.getVisibility()==View.INVISIBLE)
        {
            circularTest.setVisibility(View.VISIBLE);
            circularTest.setText("Hello  Friends \n I this Naresh kumar Rauniyar From Mahrajganj");
            ViewAnimationUtils.createCircularReveal(circularTest,centerX,centerY,0,radius).start();

        }
        else
        {

            Animator animator=ViewAnimationUtils.createCircularReveal(circularTest,centerX,centerY,radius,0);

            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    circularTest.setVisibility(View.INVISIBLE );
                }
            });

            animator.start();

        }

    }
}
