package info.juanmendez.md.materialdesigncompat;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @ViewById
    Toolbar toolbar;

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @ViewById(R.id.txvSelectedText)
    TextView selectedText;

    @ViewById(R.id.nav_view)
    NavigationView navigationView;

    @InstanceState
    String retainedTitle = "";

    @AfterViews
    void afterViews(){
        this.setSupportActionBar( toolbar );

        //in our other demo Android-Material-Design, the sliding fragment is the one used
        //to connect drawerFragment.setUpDrawer(drawerLayout, toolbar);
        //I tested using drawerToggle, and everything was fine as well.

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open,
                R.string.drawer_close );

        drawerLayout.addDrawerListener( drawerToggle);

        //we need to syncState, otherwise, the toggle button won't appear at the toolbar!
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        selectedText.setText(retainedTitle);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String itemName = (String) item.getTitle();
        selectedText.setText( itemName );
        retainedTitle = itemName;
        hideDrawer();

        return true;
    }

    @Override
    public void onBackPressed(){
        if( drawerLayout.isDrawerOpen( GravityCompat.START)){
            hideDrawer();
        }else{
            super.onBackPressed();
        }
    }


    private void hideDrawer(){
        drawerLayout.closeDrawer( GravityCompat.START );
    }

    private void showDrawer(){
        drawerLayout.openDrawer( GravityCompat.START );
    }
}
