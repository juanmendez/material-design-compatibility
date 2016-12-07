 package info.juanmendez.md.materialdesigncompat;

 import android.support.design.widget.FloatingActionButton;
 import android.support.v7.app.AppCompatActivity;
 import android.support.v7.widget.Toolbar;
 import android.widget.Toast;

 import org.androidannotations.annotations.AfterViews;
 import org.androidannotations.annotations.EActivity;
 import org.androidannotations.annotations.ViewById;

 @EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    FloatingActionButton fab;

     @AfterViews
     void afterViews(){
         this.setSupportActionBar( toolbar );

         fab.setOnClickListener(view -> {
             Toast.makeText( MainActivity.this, "FAB clicked!!", Toast.LENGTH_LONG).show();
         });
     }
}
