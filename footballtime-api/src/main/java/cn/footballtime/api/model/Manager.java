package cn.footballtime.api.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/1/5.
 */
@Getter
@Setter
public class Manager {
    private String userName;
    private String Password;
    private String SaltFigure;
}
