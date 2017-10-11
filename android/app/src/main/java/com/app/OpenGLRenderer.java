package com.app;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES20.GL_COLOR_BUFFER_BIT;
import static android.opengl.GLES20.*;
import static java.lang.Math.*;

import android.opengl.GLSurfaceView.Renderer;

public class OpenGLRenderer implements Renderer {

  double tick = 0.0;

  @Override
  public void onDrawFrame(GL10 arg0) {
    tick += 0.01;
    glClearColor((float)sin(tick), (float)sin(tick-2/3*PI), (float)sin(tick-4/3*PI), 1);
    glClear(GL_COLOR_BUFFER_BIT);
    
  }

  @Override
  public void onSurfaceChanged(GL10 arg0, int width, int height) {
    glViewport(0, 0, width, height);

  }

  @Override
  public void onSurfaceCreated(GL10 arg0, EGLConfig arg1) {
  }

}