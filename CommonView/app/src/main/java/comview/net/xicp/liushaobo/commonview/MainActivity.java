package comview.net.xicp.liushaobo.commonview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import comview.net.xicp.liushaobo.commonview.Dialog.NoTitleDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoTitleDialog noTitleDialog = new NoTitleDialog(getApplicationContext());
        //noTitleDialog.show();
    }


}
