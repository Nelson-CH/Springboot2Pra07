package org.example.springboot2pra07.entity;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class Order_36 {
    @NotEmpty(message = "請求流水號不能為空")
    private String requestNo;

    @Min(value = 1, message = "至少購買1件")
    @Max(value = 10, message = "最多不超過10件")
    private int amount;


	@Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手機號碼格式錯誤")
    @NotBlank(message = "手機號碼格式為空")
    private String phone;

    @Email
    private String goodsName;
}
