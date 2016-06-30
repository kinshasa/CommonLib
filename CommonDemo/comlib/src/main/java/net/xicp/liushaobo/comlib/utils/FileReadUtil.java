package net.xicp.liushaobo.comlib.utils;

import android.content.Context;
import android.content.res.AssetManager;

import org.apache.http.util.EncodingUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReadUtil {

    public static String ReadAssetFile(Context context, String file) {

        String str = "";
        try {
            byte[] buffer;
            AssetManager s = context.getAssets();
            InputStream is = s.open(file);
            buffer = new byte[is.available()];
            is.read(buffer);
            str = new String(buffer, "utf-8");
            is.close();
        } catch (Exception e) {
        }
        return str;
    }

    //写数据到SD中的文件
    public void writeFileSdcardFile(String fileName, String write_str) throws IOException {
        try {

            FileOutputStream fout = new FileOutputStream(fileName);
            byte[] bytes = write_str.getBytes();

            fout.write(bytes);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //读SD中的文件
    public String readFileSdcardFile(String fileName) throws IOException {
        String res = "";
        try {
            FileInputStream fin = new FileInputStream(fileName);

            int length = fin.available();

            byte[] buffer = new byte[length];
            fin.read(buffer);


            res = EncodingUtils.getString(buffer, "UTF-8");
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
