package com.app;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.ni55an.opengl_example.NativeOpenGLSurface;

public class GLSurfaceManager extends SimpleViewManager<NativeOpenGLSurface> {

    public static final String REACT_CLASS = "GLSurface";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected NativeOpenGLSurface createViewInstance(ThemedReactContext reactContext) {
        return new NativeOpenGLSurface(reactContext);
    }

}