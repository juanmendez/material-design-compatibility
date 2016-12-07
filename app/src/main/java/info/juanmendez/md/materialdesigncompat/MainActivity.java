 package info.juanmendez.md.materialdesigncompat;

 import android.support.v4.widget.DrawerLayout;
 import android.support.v7.app.ActionBarDrawerToggle;
 import android.support.v7.app.AppCompatActivity;
 import android.support.v7.widget.Toolbar;

 import org.androidannotations.annotations.AfterViews;
 import org.androidannotations.annotations.EActivity;
 import org.androidannotations.annotations.ViewById;

 @EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

     @ViewById(R.id.drawer_layout)
     DrawerLayout drawerLayout;

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
     }
}
