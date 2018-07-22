package naresh.mrj.com.animationscrool;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class RippleActivity extends AppCompatActivity {


    ImageView logo,dp;
    TextView name;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ripple);
        logo=findViewById(R.id.logo_image);
        dp=findViewById(R.id.dp_pic);
        name=findViewById(R.id.name);

        setUpWindowAnimation();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setUpWindowAnimation() {

        Slide slideTransition=new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        //slideTransition.setInterpolator(new AnticipateOvershootInterpolator());
        slideTransition.setDuration(1000l);
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
        getWindow().setAllowReturnTransitionOverlap(false);


    }

    public void checkRippleAnimation(View view) {

        Intent i=new Intent(this,Ripple.class);
        startActivity(i);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void sharedElementTransition(View view) {
          Pair []pair=new Pair[3];

          pair[0]=new Pair<View,String>(logo,"naresh_logo");
          pair[1]=new Pair<View,String>(name,"name");
          pair[2]=new Pair<View,String>(dp,"profile_pic");

        ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation(this,pair);
        Intent i=new Intent(RippleActivity.this,SharedElementActivity.class);
        startActivity(i,activityOptions.toBundle());
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void ExplodeTransitionByJava(View view)
    {
        switch (view.getId())
        {
            case R.id.explode1:
            {
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i=new Intent(this,TransitionActivity.class);
                i.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.ExplodeJava);
                i.putExtra(Constants.KEY_TITLE,"Explode By Java");
                startActivity(i,options.toBundle());
                break;
            }
            case R.id.slide1:
            {
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i=new Intent(this,TransitionActivity.class);
                i.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.SlideJava);
                i.putExtra(Constants.KEY_TITLE,"Slide By Java");
                startActivity(i,options.toBundle());
                break;
            }

            case R.id.fad1:
            {
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i=new Intent(this,TransitionActivity.class);
                i.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.FadeJava);
                i.putExtra(Constants.KEY_TITLE,"Fade By Java");
                startActivity(i,options.toBundle());
                break;

            }


        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void ExplodeTransitionByXML(View view)
    {

        switch (view.getId())
        {
            case R.id.explode2:
            {
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i=new Intent(this,TransitionActivity.class);
                i.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.ExplodeXML);
                i.putExtra(Constants.KEY_TITLE,"Explode By XML");
                startActivity(i,options.toBundle());
                break;
            }
            case R.id.slide2:
            {
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i=new Intent(this,TransitionActivity.class);
                i.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.SlideXML);
                i.putExtra(Constants.KEY_TITLE,"Slide By XML");
                startActivity(i,options.toBundle());
                break;

            }
            case R.id.fad2:
            {
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(this);
                Intent i=new Intent(this,TransitionActivity.class);
                i.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.FadeXML);
                i.putExtra(Constants.KEY_TITLE,"Fade By XML");
                startActivity(i,options.toBundle());
                break;
            }


        }
    }
}
