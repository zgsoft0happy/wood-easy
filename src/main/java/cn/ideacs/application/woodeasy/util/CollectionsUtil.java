package cn.ideacs.application.woodeasy.util;

import java.util.Collection;

/**
 * @author yang
 * @date 18-5-23 上午10:43
 */
public class CollectionsUtil {
    public CollectionsUtil() {
    }

    public static Boolean isEmpty(Collection collection) {
        return collection == null && collection.isEmpty() ? true : false;
    }
}
