package com.tinnkyou.param;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter@Setter
public class TestVo {
    @NotBlank
    private String msg;
    @NotNull
    @Max(value = 10,message = "id 最大为10")
    @Min(1)
    private Integer id;
    @NotEmpty
    private List<String> list;
}
