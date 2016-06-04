package vccorp.com.linkhay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import vccorp.com.linkhay.ui.BaseActivity;
import vccorp.com.linkhay.ui.SearchActivity;

public class MainActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState) {

    }

    @Override
    protected void initData(Bundle saveInstanceState) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // Add the search button to the toolbar.
        Toolbar toolbar = getActionBarToolbar();
        toolbar.inflateMenu(R.menu.explore_io_menu);
        toolbar.setOnMenuItemClickListener(this);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                startActivity(new Intent(this, SearchActivity.class));
                return true;
        }
        return false;
    }
}
