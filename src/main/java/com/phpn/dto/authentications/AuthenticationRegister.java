package com.phpn.dto.authentications;

import com.phpn.dto.locationRegion.LocationRegionCreate;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;

import lombok.experimental.Accessors;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AuthenticationRegister {

    @Size(min = 6, max = 50, message = "Họ và tên phải trong khoảng từ 6 đến 50 kí tự!")
    @NotBlank(message = "Họ và tên không được để trống!")
    private String name;

    @Size(min = 10, max = 11, message = "Số điện thoại phải trong khoảng từ 10 đến 11 kí tự!")
    @NotBlank(message = "Số điện thoại không được để trống!")
    private String phone;

    @Size(min = 8, max = 50, message = "Địa chỉ email phải trong khoảng từ 8 đến 50 kí tự!")
    @NotBlank(message = "Địa chỉ email không được để trống!")
    private String email;

    @Size(min = 6, max = 32, message = "Mật khẩu phải trong khoảng từ 6 đến 32 kí tự!")
    @NotBlank(message = "Mật khẩu không được để trống!")
    private String password;

    private Integer locationRegionId;
    private LocationRegionCreate locationRegionCreate;

}