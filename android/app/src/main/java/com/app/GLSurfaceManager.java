package com.app;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class GLSurfaceManager extends SimpleViewManager<GLSurface> {

    public static final String REACT_CLASS = "GLSurface";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected GLSurface createViewInstance(ThemedReactContext reactContext) {
        return new GLSurface(reactContext);
    }

}