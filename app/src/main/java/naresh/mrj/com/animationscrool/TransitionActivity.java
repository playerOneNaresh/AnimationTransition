package naresh.mrj.com.animationscrool;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

public class TransitionActivity extends AppCompatActivity {

    Constants.TransitionType type;
    String toolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_transition);

        getWindow().setAllowEnterTransitionOverlap(false);

        initPage();
        initAnimation();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initAnimation()
    {

        switch (type)
        {
            case ExplodeJava:
            {
                Explode explodeTransition=new Explode();
                explodeTransition.setDuration(1000L);
                getWindow().setEnterTransition(explodeTransition);

                break;
            }

            case ExplodeXML:
            {
                Transition transition= TransitionInflater.from(this).inflateTransition(R.transition.explode);
                getWindow().setEnterTransition(transition);
                break;
            }
            case SlideJava:
            {
                Slide slideTransition=new Slide();
                slideTransition.setSlideEdge(Gravity.BOTTOM);
                slideTransition.setInterpolator(new AnticipateOvershootInterpolator());
                slideTransition.setDuration(1000l);
                getWindow().setEnterTransition(slideTransition);

                break;
            }
            case SlideXML:
            {
                Transition transition= TransitionInflater.from(this).inflateTransition(R.transition.slide);
                getWindow().setEnterTransition(transition);
                break;
            }
            case FadeJava:
            {
                Fade fadeTransition=new Fade();
                fadeTransition.setDuration(1000l);
                getWindow().setEnterTransition(fadeTransition);


                break;
            }
            case FadeXML:
            {
                Transition transition= TransitionInflater.from(this).inflateTransition(R.transition.fade);
                getWindow().setEnterTransition(transition);

                break;
            }
        }

    }

    private void initPage()
    {
       type= (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);
       toolBarTitle=getIntent().getExtras().getString(Constants.KEY_TITLE);

        Button buttonBackTransition=findViewById(R.id.back_exit_explode);
        buttonBackTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                }
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolBarTitle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }
        return true;
    }
}
