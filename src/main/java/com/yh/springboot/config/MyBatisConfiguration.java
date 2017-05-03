package com.yh.springboot.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Order(3)
@Configuration
@Import( {DruidConfiguration.class} )
public class MyBatisConfiguration {

    @Bean(name = "masterdataSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterdataSqlSessionFactoryBean(@Qualifier("masterDatasource") DataSource dataSource) {
    	
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.yh.springboot.dao.masterdata");

        // 分页插件
        setPaginationPlugin(bean);

        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:com/yh/springboot/mapper/masterdata/*.xml"));
            bean.setConfigLocation(resolver.getResource("classpath:/mybatis-config.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "masterdataSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate masterdataSqlSessionTemplate(@Qualifier("masterDatasource") DataSource dataSource) {
        return new SqlSessionTemplate(masterdataSqlSessionFactoryBean(dataSource));
    }
    
    @Bean
    public MapperScannerConfigurer masterdataMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("masterdataSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.yh.springboot.dao.masterdata");
        return mapperScannerConfigurer;
    }
    
    private void setPaginationPlugin(SqlSessionFactoryBean sqlSessionFactory) {
    	
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
//		properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        properties.setProperty("rowBoundsWithCount", "true");

        pageHelper.setProperties(properties);

        // 添加插件
        sqlSessionFactory.setPlugins(new Interceptor[] { pageHelper });
    }

}
