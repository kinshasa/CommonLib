package net.xicp.liushaobo.cilent.util;

/**
 * Created by liushaobo.xicp.net on 2016/6/14.
 */
public class ImageLoader {

    private static ImageLoader loader;

    private static synchronized ImageLoader getInstance() {
        if (loader == null) {
            loader = new ImageLoader();


        }
        return loader;
    }



}
