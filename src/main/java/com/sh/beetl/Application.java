package com.sh.beetl;

import com.alibaba.druid.pool.DruidDataSource;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.SQLiteStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@SpringBootApplication
public class Application {
    
    @Value("${server.debug}")
    private boolean debug;
    
    @Bean(name="dataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DruidDataSource getDataSource() {
        return new DruidDataSource();
    }
    
    
    @Bean(name = "beetlSqlScannerConfigurer")
    public BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer() {
        BeetlSqlScannerConfigurer conf = new BeetlSqlScannerConfigurer();
        conf.setBasePackage("com.gb.test.dao");
        conf.setDaoSuffix("Dao");
        conf.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");
        return conf;
    }
    
    @Bean(name = "sqlManagerFactoryBean")
    @Primary
    public SqlManagerFactoryBean getSqlManagerFactoryBean(@Qualifier("dataSource") DataSource datasource) {
        
        SqlManagerFactoryBean factory = new SqlManagerFactoryBean();
        BeetlSqlDataSource source = new BeetlSqlDataSource();
        source.setMasterSource(datasource);
        
        factory.setCs(source);
        factory.setDbStyle(new SQLiteStyle());
        factory.setInterceptors(debug ? new Interceptor[] {new DebugInterceptor() } : new Interceptor[0]);
        factory.setNc(new UnderlinedNameConversion());
        factory.setSqlLoader(new ClasspathLoader("/sql"));
        return factory;
    }
    
    @Bean(name="txManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("dataSource") DataSource datasource) {
        DataSourceTransactionManager dsm = new DataSourceTransactionManager();
        dsm.setDataSource(datasource);
        return dsm;
    }
    
    @Bean(initMethod = "init", name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ClasspathResourceLoader cploder = new ClasspathResourceLoader("templates");
        beetlGroupUtilConfiguration.setResourceLoader(cploder);
        
        ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        beetlGroupUtilConfiguration.setConfigFileResource(patternResolver.getResource("classpath:beetl.properties"));
        return beetlGroupUtilConfiguration;
    }
    
    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        beetlSpringViewResolver.setSuffix(".btl");
        return beetlSpringViewResolver;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
