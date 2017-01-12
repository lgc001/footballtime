package cn.footballtime.api.service.impl;

import cn.footballtime.api.dao.ManagerRepository;
import cn.footballtime.api.model.Manager;
import cn.footballtime.api.service.ManageService;
import cn.footballtime.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/1/12.
 */
@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private ManagerRepository _managerRepository;

    public boolean login(String userName, String password) {
        Manager obj = _managerRepository.getManager(userName);
        password = SecurityUtil.encryptMD5(obj.getSaltFigure() + password).toUpperCase();

        if (!password.equals(obj.getPassword())) {
            return false;
        }
        return true;
    }
}
