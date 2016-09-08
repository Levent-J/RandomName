package com.levent_j.name;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{
    @Bind(R.id.rb_sex_man) RadioButton man;
    @Bind(R.id.rb_sex_woman) RadioButton woman;
    @Bind(R.id.rb_name_2) RadioButton name2;
    @Bind(R.id.rb_name_3) RadioButton name3;
    @Bind(R.id.tv_name) TextView name;

    String[] FirstName1 = new String[]{
            "赵","钱","孙","李","周","吴","郑","王",
            "冯","陈","褚","卫","蒋","沈","韩","杨",
            "江","姜","风","梅","尹","范","任","张",
            "杭","古","巫","左","石","燕","宋","廖",
            "乔","卓","苍","甘","谷","黎","公","谭"
    };
    String[] FirstName2 = new String[]{
            "司马","公孙","诸葛","东方","西门","南宫","长孙","宇文",
            "轩辕","黄埔","欧阳","夏侯","司空","司徒","钟离","慕容",
            "令狐","百里"
    };
    String[] LastName1 = new String[]{
            "梦","清","浩","昊","豪","燕","平","夏",
            "蔓","兰","","左","石","燕","宋","廖",
            "杭","古","巫","左","石","燕","宋","廖",
    };
    String[] LastName2 = new String[]{

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.rb_sex_man)
    void onCLickMan(View v){
        woman.setChecked(false);
    }

    @OnClick(R.id.rb_sex_woman)
    void onCLickWoMan(View v){
        man.setChecked(false);
    }

    @OnClick(R.id.rb_name_2)
    void onCLickName2(View v){
        name3.setChecked(false);
    }

    @OnClick(R.id.rb_name_3)
    void onCLickName3(View v){
        name2.setChecked(false);
    }


    @OnClick(R.id.btn_create)
    void onCLickCreate(View view){

        boolean sexMan = true;
        int nameLength = 2;

        if (man.isChecked()){
            sexMan = true;
        }else {
            sexMan = false;
        }

        if (name2.isChecked()){
            nameLength=2;
        }else if (name3.isChecked()){
            nameLength=3;
        }else {
            nameLength=4;
        }

        name.setText(createRandomName(sexMan,nameLength));

    }

    private String createRandomName(boolean sexMan, int nameLength) {
        String firstName;
        String lastName;
        firstName = createRandomFirstName(nameLength);
        lastName = createRandomLastName(sexMan,nameLength);
        return firstName+lastName;
    }


    private String createRandomFirstName(int nameLength) {
        if (nameLength==2){
            return FirstName1[new Random().nextInt(FirstName1.length)];
        }else {
            return FirstName2[new Random().nextInt(FirstName2.length)];

        }
    }

    private String createRandomLastName(boolean sexMan, int nameLength) {
        return String.valueOf((char)(0x4e00+(int)(Math.random()*(0x9fa5-0x4e00+1))));
    }
}
