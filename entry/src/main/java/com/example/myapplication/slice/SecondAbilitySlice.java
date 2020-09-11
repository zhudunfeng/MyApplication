package com.example.myapplication.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

import ohos.aafwk.content.Operation;
import ohos.agp.components.*;
import ohos.agp.components.DirectionalLayout.LayoutConfig;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.TextAlignment;

import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_CONTENT;
import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_PARENT;

public class SecondAbilitySlice extends AbilitySlice {

    private DirectionalLayout myLayout = new DirectionalLayout(this);

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        //声明布局
        DependentLayout myLayout = new DependentLayout(this);
        //设置布局大小
        myLayout.setWidth(MATCH_PARENT);
        myLayout.setHeight(MATCH_PARENT);

        //设置背景色
        ShapeElement element = new ShapeElement();
        element.setRgbColor(new RgbColor(0,0,0));
        myLayout.setBackground(element);

        //创建一个文本
        Text text = new Text(this);
        text.setText("Nice to meet you");
        text.setWidth(MATCH_PARENT);
        text.setTextColor(Color.WHITE);

        //设置文本布局大小
        DependentLayout.LayoutConfig textConfig = new DependentLayout.LayoutConfig(MATCH_CONTENT, MATCH_CONTENT);
        textConfig.addRule(DependentLayout.LayoutConfig.CENTER_IN_PARENT);
        text.setLayoutConfig(textConfig);

        //将文本组件添加布局
        myLayout.addComponent(text);

        Button button = new Button(this);
        textConfig.setMargins(0, 0, 0, 0);
        button.setLayoutConfig(textConfig);
        button.setText("Nice to meet you.");
        button.setTextSize(50);
        button.setId(100);
        ShapeElement background = new ShapeElement();
        background.setRgbColor(new RgbColor(0, 125, 255));
        background.setCornerRadius(25);
        button.setBackground(background);
        button.setPadding(10, 10, 10, 10);
        button.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                Intent secondIntent = new Intent();
                // 指定待启动FA的bundleName和abilityName
                Operation operation = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withBundleName("com.example.myapplication")
                        .withAbilityName("com.example.myapplication.MainAbility")
                        .build();
                secondIntent.setOperation(operation);
                startAbility(secondIntent); // 通过AbilitySlice的startAbility接口实现启动另一个页面
            }
        });
        myLayout.addComponent(button);


        super.setUIContent(myLayout);

    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
