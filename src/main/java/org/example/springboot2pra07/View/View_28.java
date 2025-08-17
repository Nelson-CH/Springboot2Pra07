package org.example.springboot2pra07.View;

//透過定義不同的介面進行分組, 也可以定義成 class 甚至寫在 entity 中也可以
public interface View_28 {
    interface BaseView{}

    //同時包含 BaseView 的欄位 + DetailView 的欄位。
    interface DetailView extends BaseView {
    }
}
