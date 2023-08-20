package com.santechture.api.dto.admin;

import com.santechture.api.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
public class AdminDto {

    private Integer adminId;

    private String username;
	private String token;
    public AdminDto(Admin admin){
        setAdminId(admin.getAdminId());
        setUsername(admin.getUsername());
    }

}
