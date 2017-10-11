package com.ni55an.opengl_example;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class NativeOpenGLSurface extends GLSurfaceView
        implements GLSurfaceView.Renderer, View.OnTouchListener, KeyEvent.Callback {

    static {
        System.loadLibrary("opengl_example");
    }

    protected native void nativeStart();

    protected native void nativePause();

    protected native void nativeResume();

    protected native void nativeStop();

    protected native void nativeResize(int w, int h);

    protected native void nativeRender();

    protected native void nativeDown(int id, float x, float y);

    protected native void nativeMove(int id, float x, float y);

    protected native void nativeUp(int id, float x, float y);

    protected native void nativeKeyDown(int keycode, boolean ctrl, boolean alt, boolean shift);

    protected native void nativeKeyUp(int keycode, boolean ctrl, boolean alt, boolean shift);

    public NativeOpenGLSurface(Context context) {
        super(context);

        setOnTouchListener(this);

        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();

        if (configurationInfo.reqGlEsVersion >= 0x20000) {
            setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            setEGLContextClientVersion(2);
            setRenderer(this);

        } else {
            String msg = "This device does not support OpenGL ES 2.0";

            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        nativeStart();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        nativeResize(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        nativeRender();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        super.surfaceCreated(holder);
        setFocusable(true);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        super.surfaceDestroyed(holder);
        nativeStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        nativeResume();

    }

    @Override
    public void onPause() {
        super.onPause();
        nativePause();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int actionMask = event.getActionMasked();
        int pointerId = event.getPointerId(event.getActionIndex());

        final float x = event.getX();
        final float y = event.getY();

        switch (actionMask) {
        case MotionEvent.ACTION_DOWN:
            nativeDown(pointerId, x, y);
        case MotionEvent.ACTION_POINTER_DOWN:
            break;
        case MotionEvent.ACTION_MOVE:
            nativeMove(pointerId, x, y);
            break;
        case MotionEvent.ACTION_CANCEL:
            nativeUp(pointerId, x, y);
        case MotionEvent.ACTION_UP:
            nativeUp(pointerId, x, y);
        case MotionEvent.ACTION_POINTER_UP:
            break;
        }

        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        nativeKeyDown(keyCode, event.isCtrlPressed(), event.isAltPressed(), event.isShiftPressed());
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        nativeKeyUp(keyCode, event.isCtrlPressed(), event.isAltPressed(), event.isShiftPressed());
        return super.onKeyUp(keyCode, event);
    }
}