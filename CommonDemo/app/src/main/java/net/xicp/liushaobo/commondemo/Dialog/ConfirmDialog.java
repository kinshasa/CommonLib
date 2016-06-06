package net.xicp.liushaobo.commondemo.Dialog;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import net.xicp.liushaobo.commondemo.R;

/**
 * Created by liushaobo.xicp.net on 2016/6/1.
 */
public class ConfirmDialog extends BaseDialog implements View.OnClickListener{

    private Context context;
    private View contextView;
    private Button btn_comfim_pay;

    public ConfirmDialog(Context context){
        super(context);

        this.context = context;
        initView();
    }

    public void initView (){

        contextView = getLayoutInflater().inflate(R.layout.pop_confirmdialog,null,false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.MATCH_PARENT);

        setCancelable(false);
        setCanceledOnTouchOutside(true);
        this.addContentView(contextView,layoutParams);

        btn_comfim_pay = (Button)findViewById(R.id.btn_comfim_pay);
        btn_comfim_pay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("liushaobo","test");
        dismiss();
    }
}
