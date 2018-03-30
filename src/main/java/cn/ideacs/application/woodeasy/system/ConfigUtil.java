package cn.ideacs.application.woodeasy.system;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

import java.util.Properties;
import java.util.Set;

/**
 * @author yang
 * @date 17-12-19
 */
public class ConfigUtil  extends PropertyPlaceholderConfigurer implements InitializingBean{


    private static Properties config = new Properties();

    @Override
    public void setLocations(Resource... locations) {

        if (locations == null || locations.length <= 0) {
            return;
        }
        Resource resource = locations[0];

        try {
            config.load(resource.getURL().openStream());
            if (locations.length > 1) {
                for (int i = 1 ; i < locations.length ; i++) {
                    Properties properties = new Properties();
                    properties.load(locations[i].getURL().openStream());
                    Set<Object> set = properties.keySet();
                    for (Object key : set) {
                        if (config.containsKey(key)) {
                            continue;
                        }
                        config.put(key, properties.get(key));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("初始化配置文件失败");
            e.printStackTrace();
        }
        super.setLocations(locations);
    }

    public static String get(String key) {
        return config.getProperty(key);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化配置文件成功");
    }
}
