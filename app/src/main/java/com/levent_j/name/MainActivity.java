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
    @Bind(R.id.rb_name_random) RadioButton nameR;
    @Bind(R.id.rb_name_static) RadioButton nameS;
    @Bind(R.id.rb_name_2) RadioButton name2;
    @Bind(R.id.rb_name_3) RadioButton name3;
    @Bind(R.id.tv_name) TextView name;

    String[] FirstName1 = new String[]{
            "赵","钱","孙","李","周","吴","郑","王",
            "冯","陈","褚","卫","蒋","沈","韩","杨",
            "江","姜","风","梅","尹","范","任","张",
            "杭","古","巫","左","石","燕","宋","廖",
            "乔","卓","苍","甘","谷","黎","公","谭",
            "帝","余","秋","来","白","梁","夫","勾",
            "韦","陈","程","岳","曲","阮","汤","幽",
            "仇","孔","曹","夏","章","卢","单","潘",
            "百","渊","虢","鞠","天","鬼","霍","柏",
            "龙","泉","风","莫","羊","崔","蒲","夜",
    };
    String[] FirstName2 = new String[]{
            "司马","公孙","诸葛","东方","西门","南宫","长孙","宇文",
            "轩辕","黄埔","欧阳","夏侯","司空","司徒","钟离","慕容",
            "令狐","百里","太史"
    };
    String[] LastName1 = new String[]{
            "梦","清","浩","昊","豪","燕","平","夏",
            "蔓","兰","仙","左","石","禹","翔","龙",
            "杭","古","舞","帝","双","岑","芳","辽",
            "春","夏","秋","冬","梅","兰","菊","竹",
            "冲","傲","世","天","庚","岚","封","枫",
            "月","日","阳","音","书","彤","越","良",
            "峰","东","南","西","北","武","健","剑",
            "渊","媛","波","恬","全","炎","鑫","垚",
            "耀","旭","浪","羽","游","幽","明","蝶",
            "墨","涛","九","纶","城","晨","诚","亮",
            "夜","春","秋","冬","雪","桃","尧","业",
    };
    String[] LastName2 = new String[]{
            "梦","清","浩","昊","豪","燕","平","夏",
            "蔓","兰","仙","左","石","禹","翔","龙",
            "杭","古","舞","帝","双","岑","芳","辽",
            "春","夏","秋","冬","梅","兰","菊","竹",
            "冲","傲","世","天","庚","岚","封","枫",
            "月","日","阳","音","书","彤","越","良",
            "峰","东","南","西","北","武","健","剑",
            "渊","媛","波","恬","全","炎","鑫","垚",
            "耀","旭","浪","羽","游","幽","明","蝶",
            "墨","涛","九","纶","城","晨","诚","亮",
            "夜","春","秋","冬","雪","桃","尧","业",
            "长苏","无双","弦月","清风","梦蝶","玉京","弑天","释天",
            "承伯","世威","玉林","不群","天翔","安然","阳明","问天",
            "辽纯","鹤翔","文天","一波","羲之","福全","志雷","旭东",
            "梦埙","江山","梦玲","飞燕","流觞","襄铃","俊临","东升",
            "临仙","嘉杰","伊岚","天河","天辉","春秋","潜龙","飞天",
            "梦琪","忆柳","语兰","夏涵","蒹葭","谷雪","书柏","紫晴",
            "凝竹","寒瑶","千仞","飞雪","采白","碧渊","飞双","幻天",
            "丹青","元举","千风","流苏","流连","静灵","白夜","莫风",
            "夜幽","春申","深秋","冬梅","雪瑶","桃仙","尧天","业炎",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.rb_name_random)
    void onCLickMan(View v){
        nameS.setChecked(false);
    }

    @OnClick(R.id.rb_name_static)
    void onCLickWoMan(View v){
        nameR.setChecked(false);
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

        boolean random = true;
        int nameLength = 2;

        if (nameR.isChecked()){
            random = true;
        }else {
            random = false;
        }

        if (name2.isChecked()){
            nameLength=2;
        }else if (name3.isChecked()){
            nameLength=3;
        }else {
            nameLength=4;
        }

        name.setText(createRandomName(random,nameLength));

    }

    private String createRandomName(boolean random, int nameLength) {
        String firstName;
        String lastName;
        firstName = createRandomFirstName(nameLength);
        lastName = createRandomLastName(random);
        return firstName+lastName;
    }


    private String createRandomFirstName(int nameLength) {
        if (nameLength==2){
            return FirstName1[new Random().nextInt(FirstName1.length)];
        }else {
            return FirstName2[new Random().nextInt(FirstName2.length)];

        }
    }

    private String createRandomLastName(boolean random) {
//        return String.valueOf((char)(0x4e00+(int)(Math.random()*(0x9fa5-0x4e00+1))));
        if (random){
            if (new Random().nextInt(2)==0){
                return LastName1[new Random().nextInt(LastName1.length)]+LastName1[new Random().nextInt(LastName1.length)];
            }else {
                return LastName1[new Random().nextInt(LastName1.length)];
            }
        }else {
            return LastName2[new Random().nextInt(LastName2.length)];
        }
    }
}
