package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{yyyymmdd}")
    // {}の値を取得し、変数へString型代入
    public String dispDayOfWeek(@PathVariable String yyyymmdd) {

        //subStringで取得した値をyyyy(年),mm(月),dd(日)に分ける
        String yyyy = yyyymmdd.substring(0, 4);
        String mm = yyyymmdd.substring(4, 6);
        String dd = yyyymmdd.substring(6);

        //　分けた年、月、日をint型にする。(LocalDateメソッドの引数(int)型にした変数で曜日を取得するため)
        Integer y = Integer.parseInt(yyyy);
        Integer m = Integer.parseInt(mm);
        Integer d = Integer.parseInt(dd);

        LocalDate ld = LocalDate.of(y, m, d); // (LocalDate.of）はLocalDateのインスタンスを取得するメソッド
        DayOfWeek dayOfWeek = DayOfWeek.from(ld); //DayOfWeekで年、月、日(ld)の曜日を取得
        String str = dayOfWeek.toString(); //取得したDayofWeeKをString型(文字列)に変換して変数へ代入

        System.out.println(dayOfWeek); //確認用

        return str;
    }
    
    // ----ここから仕様2----
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res =0;
        res = val1 + val2;
        return"実行結果：" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res =0;
        res = val1 - val2;
        return"実行結果：" + res;
    }
    
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res =0;
        res = val1 * val2;
        return"実行結果：" + res;
    }
    
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res =0;
        res = val1 / val2;
        return"実行結果：" + res;
    }
}

