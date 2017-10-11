package com.app;

import android.content.Context;
import android.opengl.GLSurfaceView;

class GLSurface extends GLSurfaceView {
    
    public GLSurface(Context context){
        super(context);

        setEGLContextClientVersion(2);
        setRenderer(new OpenGLRenderer());
    }   
}