package ness.tomerbu.edu.animationspractice;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView cloud1, cloud2, cloud3, cloud4;
    Animator c1Anim;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cloud1 = (ImageView) findViewById(R.id.cloud1);
        cloud2 = (ImageView) findViewById(R.id.cloud2);
        cloud3 = (ImageView) findViewById(R.id.cloud3);
        cloud4 = (ImageView) findViewById(R.id.cloud4);
        r = new Random();
/*        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            c1Anim = AnimatorInflater.loadAnimator(this, R.animator.cloud1);
            c1Anim.setTarget(cloud1);
            c1Anim.start();
        }*/


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        animateCloud(cloud1, cloud2, cloud3, cloud4);
    }

    private void animateCloud(View... clouds){

        for (View v : clouds) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
                RelativeLayout l = (RelativeLayout) v.getParent();
                int width = l.getWidth();
                ObjectAnimator a = ObjectAnimator.ofFloat(v,
                        "translationX", -width, width);

                a.setRepeatMode(ValueAnimator.RESTART);
                a.setRepeatCount(ValueAnimator.INFINITE);
                a.setDuration(r.nextInt(3000) + 5000);

                a.start();
            }
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
