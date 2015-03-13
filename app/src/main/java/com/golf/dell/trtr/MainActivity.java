package com.golf.dell.trtr;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.twicecircled.spritebatcher.Drawer;
import com.twicecircled.spritebatcher.FontParams;
import com.twicecircled.spritebatcher.SpriteBatcher;

import javax.microedition.khronos.opengles.GL10;


public class MainActivity extends Activity implements Drawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        GLSurfaceView surface = new GLSurfaceView(this);


        setContentView(surface);

        int[] resourceIds = new int[] {R.drawable.golf,R.string.audiowide_font};

SpriteBatcher sb = new SpriteBatcher(this,resourceIds,this);
       sb.setFontParams(R.string.audiowide_font,new FontParams().size(15));

        surface.setRenderer(sb);
//surface.setRenderer(new SpriteBatcher(this,resourceIds,this));



    }


    @Override
    public void onDrawFrame(GL10 gl, SpriteBatcher sb) {
        sb.draw(R.drawable.golf, new Rect(0,0,960,560), new Rect(0,0,sb.getViewWidth(),sb.getViewHeight()));
        sb.batchDraw(gl);


        sb.draw(R.drawable.vv, new Rect(0,0,55,41),  new Rect(30,560,75,591));
        //sb.draw(R.drawable.aa, new Rect(0,0,713,392),  new Rect(250,100,713,392));

        sb.drawText(R.string.audiowide_font, "Hit_Ball",100,500,1f,0xffff0000);

    }
}
