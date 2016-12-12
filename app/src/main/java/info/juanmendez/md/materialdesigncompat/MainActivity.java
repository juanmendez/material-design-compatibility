 package info.juanmendez.md.materialdesigncompat;

 import android.support.design.widget.CollapsingToolbarLayout;
 import android.support.v7.app.AppCompatActivity;
 import android.support.v7.widget.Toolbar;

 import org.androidannotations.annotations.AfterViews;
 import org.androidannotations.annotations.EActivity;
 import org.androidannotations.annotations.OptionsMenu;
 import org.androidannotations.annotations.ViewById;

 @EActivity(R.layout.activity_main)
 @OptionsMenu(R.menu.menu)
public class MainActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

     @ViewById
     CollapsingToolbarLayout collapsingToolBar;

     @AfterViews
     void afterViews(){
         this.setSupportActionBar( toolbar );

         //this overrides the title in toolbar
         collapsingToolBar.setTitle( "Collapsing Toolbar");
     }
}
