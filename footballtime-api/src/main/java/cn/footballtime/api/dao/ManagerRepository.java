package cn.footballtime.api.dao;

import cn.footballtime.api.model.Manager;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/1/12.
 */
@Repository
public interface ManagerRepository {
    Manager getManager(String userName);
}
