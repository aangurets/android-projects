package com.example.bookstore.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

public abstract class AbstractLoader<F> extends AsyncTaskLoader<F> {

    private F mData;
    private boolean mListenerUnregistered = true;

    protected AbstractLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (mData != null) {
            deliverResult(mData);
        } else {
            if (mListenerUnregistered) {
                registerListeners();
                mListenerUnregistered = false;
            }

            if (takeContentChanged() || mData == null) {
                forceLoad();
            }
        }
    }

    @Override
    public void deliverResult(F data) {

        if (isReset()) {
            freeResource(data);
            return;
        }

        F oldData = mData;
        mData = data;

        if (isStarted()) {
            super.deliverResult(data);
        }

        if (oldData != null && oldData != data) {
            freeResource(oldData);
        }
    }

    protected F getData() {
        return mData;
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        onStartLoading();

        if (mData != null) {
            freeResource(mData);
            mData = null;
        }

        unregisterListeners();
        mListenerUnregistered = true;
    }

    protected void registerListeners() {
    }

    protected void unregisterListeners() {
    }

    @Override
    public void onCanceled(F data) {
        super.onCanceled(data);
        freeResource(data);
    }

    protected abstract void freeResource(F data); {

    }
}
