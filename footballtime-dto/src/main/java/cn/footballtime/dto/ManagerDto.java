package cn.footballtime.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/1/5.
 */
@Getter
@Setter
public class ManagerDto {
    private String userName;
    private String Password;
    private String SaltFigure;
}
