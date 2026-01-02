#include "gl-linux-glx.h"



jni_linux_glx_manager(void, nSwapBuffers)(JNIEnv* env, jobject, jlong display, jlong window) {
    glXSwapBuffers(
        (Display*) display,
        (Window) window
    );
}

jni_linux_glx_manager(void, nSetSwapInterval)(JNIEnv* env, jobject, jlong _display, jlong _window, jlong _context, jint swapInterval) {
    Display* display = (Display*)_display;
    Window window = (Window)_window;

    if (_glXSwapIntervalEXT)
        _glXSwapIntervalEXT(display, window, swapInterval);
    else if(_glXSwapIntervalMESA)
        _glXSwapIntervalMESA(swapInterval);
    else if(_glXSwapIntervalSGI)
        _glXSwapIntervalSGI(swapInterval);
}