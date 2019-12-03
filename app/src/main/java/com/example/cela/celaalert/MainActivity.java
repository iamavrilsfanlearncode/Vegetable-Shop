package com.example.cela.celaalert;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView msg;
    private Button but1,input_ur_name,btnMsg,btnAlert,btnAlert2;

//    //宣告按鈕 btnClick,btnFruit
//    private Button btnClick,btnVegetable;
    String[] str_list = {"牛番茄", "高麗菜", "杏鮑菇","紅蘿蔔","大白菜","青江菜"};
    String[] str2 = {"香蕉", "蘋果", "火龍果","葡萄","番茄","西瓜"};
    List<String> fruit=new ArrayList<>();

    private AlertDialog dialog = null;
    AlertDialog.Builder builder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg = findViewById(R.id.msg);
        but1= findViewById(R.id.but1);
        input_ur_name =findViewById(R.id.input_ur_name);
        btnMsg =findViewById(R.id.btnMsg);
        btnAlert =findViewById(R.id.btnAlert);
        btnAlert2 =findViewById(R.id.btnAlert2);
//        btnClick = findViewById(R.id.btnMsg);
//        btnVegetable = findViewById(R.id.btnAlert);

        but1.setOnClickListener(this);
        input_ur_name.setOnClickListener(this);
        btnMsg.setOnClickListener(this);
        btnAlert.setOnClickListener(this);
        btnAlert2.setOnClickListener(this);


    }//onCreate結束



    @Override
    public void onClick(View v) {
        if (v.getId() == but1.getId()) {
            /*按下but1執行*/
            msg.setText("輸入免運代碼free79");
            Toast.makeText(MainActivity.this, msg.getText().toString(), Toast.LENGTH_LONG).show();
        } else if (v.getId() == btnMsg.getId()) {
            //按下我要離開執行
            //顯示圖片mipmap.question
            builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("離開提醒")
                    .setIcon(R.mipmap.question)
                    .setMessage("確定要離開?")
                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        //設定確定按鈕
                        @Override
                        public void onClick(DialogInterface dialog, int i) {

                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        //設定取消按鈕
                        @Override
                        public void onClick(DialogInterface dialog, int i) {

                        }
                    });//按鈕btnClick End

            //顯示在畫面上
            dialog = builder.create();
            dialog.show();

        }
        //按下 多選 水果 按鈕之後執行
        else if (v.getId() == btnAlert2.getId()) {
            builder = new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this);
            builder
                    .setTitle("今天想吃什麼?")
                    .setIcon(R.mipmap.pineapple).
                    setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setMultiChoiceItems(str2, null, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i, boolean isChecked) {
                            if (isChecked) {
                                fruit.add(str2[i]);
                            } else {
                                fruit.remove(str2[i]);
                            }
                            // Toast.makeText(MainActivity.this, "選擇的是:" + str2[i], Toast.LENGTH_LONG).show();
                        }
                    }).create().show();
        }// 多選 結束

        else if (v.getId() == btnAlert.getId()) {
            //按鈕btnvegetable設定  單選蔬菜
            builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("請選擇需要的蔬菜:")
                    .setIcon(R.mipmap.salad)
                    //setSingleChoiceItems設定單選　　　checkedItem是預設跑出第幾個選項
                    .setSingleChoiceItems(str_list, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "您挑選的是:" + str_list[i], Toast.LENGTH_LONG).show();
                        }
                    });
            //顯示在畫面上
            dialog = builder.create();
            dialog.show();
        }// 單選End
        else {
            /*要給 item  final，item不可變動  */
            final View item = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout, null);
            builder = new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this);
            builder.setTitle("我想吃的是").setIcon(R.mipmap.pineapple)
                    .setView(item)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            EditText editText = (EditText) item.findViewById(R.id.edit_text);
                            String name = editText.getText().toString();
                            if (TextUtils.isEmpty(name)) {
                                Toast.makeText(getApplicationContext(), R.string.input_ur_name, Toast.LENGTH_LONG).show();

                            } else {
                                Toast.makeText(getApplicationContext(), getString(R.string.hi) + name, Toast.LENGTH_LONG).show();
                            }
                        }
                    }).show();

         }

    }//End OnClick
} //MainActivity結束
