package com.lujieni.tkmapper.mybatis.service;

import com.lujieni.tkmapper.mybatis.service.delete.IDeleteService;
import com.lujieni.tkmapper.mybatis.service.insert.IInsertService;
import com.lujieni.tkmapper.mybatis.service.select.ISelectService;
import com.lujieni.tkmapper.mybatis.service.update.IUpdateService;

public interface IBaseService<T> extends IDeleteService<T>, IInsertService<T>, IUpdateService<T>, ISelectService<T> {


}
