package com.example.fastjsondemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String string = "{\"result\":[{\"sex\":\"男\",\"age\":\"20\",\"name\":\"张三\"}," +
                "{\"sex\":\"女\",\"age\":\"22\",\"name\":\"小华\"}," +
                "{\"sex\":\"男\",\"age\":\"25\",\"name\":\"李四\"}," +
                "{\"sex\":\"女\",\"age\":\"27\",\"name\":\"小丽\"}]," +
                "\"school\":\"清华大学\",\"error\":false}";

        JSONObject jsonObject = JSON.parseObject(string);
        JSONArray jsonArray = jsonObject.getJSONArray("result");
        String jsonArrayStr = jsonArray.toJSONString();

        List<Student> list = JSON.parseArray(jsonArrayStr, Student.class);
        for (Student student : list) {
            Log.d(TAG, "name: " + student.getName());
            Log.d(TAG, "sex: " + student.getSex());
            Log.d(TAG, "age: " + student.getAge());
            Log.d(TAG, "------------------------------");
        }

        String school = jsonObject.getString("school");
        Log.d(TAG, "school: "+school);
    }

}
