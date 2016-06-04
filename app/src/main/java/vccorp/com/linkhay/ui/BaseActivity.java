package vccorp.com.linkhay.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import vccorp.com.linkhay.R;
import vccorp.com.linkhay.utils.Logger;

/**
 * Created by PC0353 on 6/2/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public final static String TAG = Logger.makeLogTag(BaseActivity.class);

    protected abstract int getLayoutResource();

    protected abstract void initVariables(Bundle saveInstanceState);

    protected abstract void initData(Bundle saveInstanceState);

    private Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        initVariables(savedInstanceState);

        initData(savedInstanceState);

    }

    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
            if (mActionBarToolbar != null) {
                // Depending on which version of Android you are on the Toolbar or the ActionBar may be
                // active so the a11y description is set here.
                mActionBarToolbar.setNavigationContentDescription(getResources().getString(R.string
                        .navdrawer_description_a11y));
                setSupportActionBar(mActionBarToolbar);
            }
        }
        return mActionBarToolbar;
    }
}
