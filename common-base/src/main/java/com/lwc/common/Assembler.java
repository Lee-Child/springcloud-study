//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.lwc.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Assembler {
    private static final ConcurrentMap<String, BeanCopier> beanCopierMap = new ConcurrentHashMap();

    public Assembler() {
    }

    public static BeanCopier getBeanCopier(Class<?> source, Class<?> target, boolean useConverter) {
        String beanCopierKey = source.getSimpleName() + "@" + target.getSimpleName() + "@useConverter" + useConverter;
        BeanCopier beanCopier = (BeanCopier)beanCopierMap.getOrDefault(beanCopierKey, BeanCopier.create(source, target, false));
        beanCopierMap.putIfAbsent(beanCopierKey, beanCopier);
        return beanCopier;
    }

    public static <T> T assemble(Class<T> target, Object source) {
        return assemble(target, source, (Converter)null);
    }

    public static <T> T assemble(Class<T> target, Object source, Converter converter) {
        if (source == null) {
            return null;
        } else {
            try {
                BeanCopier beanCopier = null;
                if (converter == null) {
                    beanCopier = getBeanCopier(source.getClass(), target, false);
                } else {
                    beanCopier = getBeanCopier(source.getClass(), target, true);
                }

                T t = target.newInstance();
                beanCopier.copy(source, t, converter);

                return t;
            } catch (Exception var6) {
                throw new RuntimeException("create object fail, class:" + target.getName() + " ", var6);
            }
        }
    }

    public static <T> List<T> multiAssemble(Class<T> target, Collection<?> sources) {
        return multiAssemble(target, sources, (Converter)null);
    }

    public static <T> List<T> multiAssemble(Class<T> target, Collection<?> sources, Converter converter) {
        List<T> targets = Lists.newArrayList();
        if (CollectionUtils.isEmpty(sources)) {
            return targets;
        } else {
            try {
                BeanCopier beanCopier = null;
                if (converter == null) {
                    beanCopier = getBeanCopier(sources.toArray()[0].getClass(), target, false);
                } else {
                    beanCopier = getBeanCopier(sources.toArray()[0].getClass(), target, true);
                }

                T t;
                for(Iterator var7 = sources.iterator(); var7.hasNext(); targets.add(t)) {
                    Object object = var7.next();
                    t = target.newInstance();
                    beanCopier.copy(object, t, converter);
                }

                return targets;
            } catch (Exception var9) {
                throw new RuntimeException("create object fail, class:" + target.getName() + " ", var9);
            }
        }
    }

    public static <T> IPage<T> iPageAssemble(Class<T> target, IPage<?> page) {
        List<T> tList = multiAssemble(target, page.getRecords());
        IPage<T> result = new Page<>();
        result.setCurrent(page.getCurrent());
        result.setPages(page.getPages());
        result.setTotal(page.getTotal());
        result.setSize(page.getSize());
        result.setRecords(tList);
        return result;
    }

    public static <T> Page<T> pageAssemble(Class<T> target, Page<?> page) {
        List<T> tList = multiAssemble(target, page.getRecords());
        Page<T> result = new Page<>();
        result.setCurrent(page.getCurrent());
        result.setPages(page.getPages());
        result.setTotal(page.getTotal());
        result.setSize(page.getSize());
        result.setRecords(tList);
        return result;
    }
}
