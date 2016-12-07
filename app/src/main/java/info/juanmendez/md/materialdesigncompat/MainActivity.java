 package info.juanmendez.md.materialdesigncompat;

 import android.graphics.Color;
 import android.support.design.widget.FloatingActionButton;
 import android.support.design.widget.Snackbar;
 import android.support.v7.app.AppCompatActivity;
 import android.support.v7.widget.Toolbar;
 import android.view.View;
 import android.widget.TextView;
 import android.widget.Toast;

 import org.androidannotations.annotations.AfterViews;
 import org.androidannotations.annotations.Click;
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

     @Click(R.id.btn_snackbar)
     void onBtnSnackbar(View v){

         //view is used to track the activity's layout or track the root layout
         //based on the activity's layout snackbar appears just at the top level with gravity
         //at the bottom. We use now CoordinatorLayout in order to attach this child of that view
         //and nest right below!
         Snackbar.make( v, "Hello from SnackBar maker!", Snackbar.LENGTH_LONG ).show();
     }

     @Click(R.id.btn_snackbar_callback)
     void onBtnSnackbarCallback(View v ){

         Snackbar snackbarWithOption = Snackbar.make( v, "Hello from SnackBar maker!", Snackbar.LENGTH_LONG );
         snackbarWithOption.show(); //this can appear here or right below.


         snackbarWithOption.setAction("RETRY", view -> {
            Snackbar.make( view, "File loaded!", Snackbar.LENGTH_LONG).show();
         });
     }

     @Click( R.id.btn_snackbar_color )
     void onBtnSnackbarCustomized( View v ){
         Snackbar snackbarCustomized = Snackbar.make( v, "Hello from SnackBar maker!", Snackbar.LENGTH_LONG );

         snackbarCustomized.setAction("RETRY", view -> {
             Snackbar.make( view, "File loaded!", Snackbar.LENGTH_LONG).show();
         });

         View snackbarLayout = snackbarCustomized.getView();
         snackbarLayout.setBackgroundColor( Color.BLUE );

         /**we modify color by simply accessing Snackbar defined views we want to customize
          * mMessageView = (TextView) findViewById(R.id.snackbar_text);
          * mActionView = (Button) findViewById(R.id.snackbar_action);
          */

         TextView txvMessage = (TextView) snackbarLayout.findViewById( android.support.design.R.id.snackbar_text);
         txvMessage.setTextColor( Color.YELLOW);

         /*this works, or else what's below
         Button optionButton = (Button) snackbarLayout.findViewById(android.support.design.R.id.snackbar_action);
         optionButton.setTextColor( Color.WHITE );*/

         snackbarCustomized.setActionTextColor( Color.WHITE );

         snackbarCustomized.show(); //this can appear here or right below.
     }
}
