package cn.ideacs.application.woodeasy.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author yang
 * @date 17-12-19
 */

public class WoodEasyDBConfig {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ideacs_db";
    private static final String USERNAME = "ideacs";
    private static final String PASSWORD = "ideacs123";
    private static final Integer poolMax = 10;

    @Bean
    public DataSource dataSourceIdeacs() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setInitialSize(2);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxTotal(poolMax);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBeanIdeacs(DataSource dataSourceIdeacs) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceIdeacs);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurerIdeacs(SqlSessionFactoryBean sqlSessionFactoryBeanIdeacs) {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("cn.ideacs.application.woodeasy.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBeanIdeacs");
        return mapperScannerConfigurer;
    }

}
