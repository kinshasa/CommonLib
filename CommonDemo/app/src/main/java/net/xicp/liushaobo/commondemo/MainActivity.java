package net.xicp.liushaobo.commondemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import net.xicp.liushaobo.commondemo.Dialog.ConfirmDialog;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ConfirmDialog confirmDialog;

    private Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("liushaobo","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        btnShowDialog = (Button)findViewById(R.id.btnShowDialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmDialog();
            }
        });

    }

    private void showConfirmDialog(){
        if(confirmDialog == null){
            confirmDialog = new ConfirmDialog(context);
        }
        if(confirmDialog.isShowing()){
            confirmDialog.hide();
        }else{
            confirmDialog.show();
        }
    }

}
