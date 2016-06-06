package net.xicp.liushaobo.comlib.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 保存共享的数据工具类
 * 
 * @author Administrator
 * 
 */
public class FieldHolds {
 

    private SharedPreferences mSharedPreferences;
 
     public FieldHolds(Context context,String name) {
        mSharedPreferences = context.getSharedPreferences(name,Context.MODE_PRIVATE);
     }
    
    
    // 保存字符串数
    public void saveString(String key, String value) {
        mSharedPreferences.edit().putString(key, value).commit();
    }

    // 获取字符串数
    public String getString(String key, String... defValue) {
        if (defValue.length > 0)
            return mSharedPreferences.getString(key, defValue[0]);
        else
            return mSharedPreferences.getString(key, "");

    }
    
    // 保存整型数据
    public void saveInt(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).commit();
    }

    // 获取整型数据
    public int getInt(String key, int  defValue) {
        return mSharedPreferences.getInt(key, defValue);

    }
      
    // 保存布尔值数
    public void saveBoolean(String key, Boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).commit();
    }

    // 获取布尔值数
    public Boolean getBoolean(String key, Boolean... defValue) {
        if (defValue.length > 0)
            return mSharedPreferences.getBoolean(key, defValue[0]);
        else
            return mSharedPreferences.getBoolean(key, false);

    }
    
    public boolean contains(String key)  
    {  
        return mSharedPreferences.contains(key);  
    } 
    
}
