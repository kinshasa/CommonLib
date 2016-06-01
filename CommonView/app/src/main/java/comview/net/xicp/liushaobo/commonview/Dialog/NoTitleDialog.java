package comview.net.xicp.liushaobo.commonview.Dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

/**
 * Created by liushaobo.xicp.net on 2016/5/27.
 */
public class NoTitleDialog extends BaseDialog {

    public NoTitleDialog(Context context){
        super(context);
        // 去掉系统对话框的title和边框背景
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }


}
