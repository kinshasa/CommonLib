package net.xicp.liushaobo.framedemo.util;

/**
 * Created by liushaobo.xicp.net on 2016/6/6.
 */
public class ConstantsReqInterface {

    public final static int REQ_LOCAL = -1; // 本地环境
    public final static int REQ_206 = 0; // 内侧环境
    public final static int REQ_206_RELEASE = 1; // 内侧Release环境
    public final static int REQ_TEST = 2; // 公测环境
    public final static int REQ_TEST_RELEASE = 3; // 公测Release环境
    public final static int REQ_ABTEST = 4; // 灰度环境
    public final static int REQ_RELEASE = 5; //正式环境


    /**
     * 快手API接口1.0
     */
    public static String URL_EVN_CAR_API_VAUE;
    public final static String URL_EVN_CAR_API_206 = "http://192.168.1.206/fengche/rest.php";
    public final static String URL_EVN_CAR_API_206_RELEASE = "http://192.168.1.206/fengche/release/rest.php";
    public final static String URL_EVN_CAR_API_TEST = "http://test.carisok.com/rest.php";
    public final static String URL_EVN_CAR_API_TEST_RELEASE = "http://test.carisok.com/release/rest.php";
    public final static String URL_EVN_CAR_API_ABTEST = "http://abtest.api.carisok.com";
    public final static String URL_EVN_CAR_API_RELEASE = "http://api.carisok.com";

    /**
     * 快手API接口2.0
     */
    public static String URL_EVN_CAR_API2_VAUE;
    public final static String URL_EVN_CAR_API2_206 = "http://192.168.1.206/fengche/icarapi.php";
    public final static String URL_EVN_CAR_API2_206_RELEASE = "http://192.168.1.206/fengche/release/icarapi.php";
    public final static String URL_EVN_CAR_API2_TEST = "http://test.carisok.com/icarapi.php";
    public final static String URL_EVN_CAR_API2_TEST_RELEASE = "http://test.carisok.com/release/icarapi.php";
    public final static String URL_EVN_CAR_API2_ABTEST = "http://abtest.api.carisok.com/icarapi.php";
    public final static String URL_EVN_CAR_API2_RELEASE = "http://api.carisok.com/icarapi.php";

    /**
     * 商城买家版API接口1.0
     */
    public static String URL_EVN_MALL_API_VAUE;
    public final static String URL_EVN_MALL_API_206 = "http://192.168.1.206/mall/mallapp.php";
    public final static String URL_EVN_MALL_API_206_RELEASE = "http://192.168.1.206/fengche/release/mallapp.php";
    public final static String URL_EVN_MALL_API_TEST = "http://test.carisok.com/mall/mallapp.php";
    public final static String URL_EVN_MALL_API_TEST_RELEASE = "http://test.carisok.com/release/mallapp.php";
    public final static String URL_EVN_MALL_API_RELEASE = "http://api.mall.carisok.com/mallapp.php";

    /**
     * 上传接口
     */
    public static String URL_EVN_UPLOAD_VAUE;
    public final static String URL_EVN_UPLOAD_206 = "http://192.168.1.206/upload/upload.php";
    public final static String URL_EVN_UPLOAD_206_RELEASE = URL_EVN_UPLOAD_206;
    public final static String URL_EVN_UPLOAD_TEST = "http://test.upload.carisok.com/upload.php";
    public final static String URL_EVN_UPLOAD_TEST_RELEASE = URL_EVN_UPLOAD_TEST;
    public final static String URL_EVN_UPLOAD_AB_TEST = "http://abtest.upload.carisok.com/upload.php";
    public final static String URL_EVN_UPLOAD_RELEASE = "http://upload.carisok.com/upload.php";

    /**
     * H5门店紅包分享接口，后期优化删除。
     */
    public static String URL_EVN_H5_STOREBONUS_SHARE_VAUE;
    public final static String URL_EVN_H5_STOREBONUS_SHARE_206 = "http://192.168.1.206/imall/test.h5.carisok.com/iCar/packet/shop/index.html?bonus_id=";
    public final static String URL_EVN_H5_STOREBONUS_SHARE_206_RELEASE = URL_EVN_H5_STOREBONUS_SHARE_206;
    public final static String URL_EVN_H5_STOREBONUS_SHARE_TEST = "http://test.h5.carisok.com/iCar/packet/shop/index.html?bonus_id=";
    public final static String URL_EVN_H5_STOREBONUS_SHARE_TEST_RELEASE = URL_EVN_H5_STOREBONUS_SHARE_TEST;
    public final static String URL_EVN_H5_STOREBONUS_SHARE_RELEASE = "http://h5.carisok.com/iCar/packet/shop/index.html?bonus_id=";

    /**
     * H5平台紅包分享接口，后期优化删除。
     */
    public static String URL_EVN_H5_PLATFORMBONUS_SHARE_VAUE;
    public final static String URL_EVN_H5_PLATFORMBONUS_SHARE_206 = "http://192.168.1.206/imall/test.h5.carisok.com/iCar/packet/platform/index.html?bonus_id=";
    public final static String URL_EVN_H5_PLATFORMBONUS_SHARE_206_RELEASE = URL_EVN_H5_PLATFORMBONUS_SHARE_206;
    public final static String URL_EVN_H5_PLATFORMBONUS_SHARE_TEST = "http://test.h5.carisok.com/iCar/packet/shop/index.html?bonus_id=";
    public final static String URL_EVN_H5_PLATFORMBONUS_SHARE_TEST_RELEASE = URL_EVN_H5_PLATFORMBONUS_SHARE_TEST;
    public final static String URL_EVN_H5_PLATFORMBONUS_SHARE_RELEASE = "http://h5.carisok.com/iCar/packet/shop/index.html?bonus_id=";

}
