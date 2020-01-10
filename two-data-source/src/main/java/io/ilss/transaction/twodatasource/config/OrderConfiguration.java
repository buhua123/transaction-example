package io.ilss.transaction.twodatasource.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author feng
 */

@Configuration
@MapperScan(basePackages = {"io.ilss.transaction.twodatasource.dao.order"}, sqlSessionTemplateRef = "orderSqlSessionTemplate")
public class OrderConfiguration {

    @Bean(name = "orderDataSource")
    public DataSource orderDataSource() {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidXADataSource.setUsername("root");
        druidXADataSource.setPassword("feng1104");
        druidXADataSource.setUrl("jdbc:mysql://127.0.0.1:3306/transaction_order?useSSL=false&characterEncoding=UTF-8");
        druidXADataSource.setDbType("mysql");
        atomikosDataSourceBean.setXaDataSource(druidXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("orderDataSource");
        return atomikosDataSourceBean;
    }

    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory accountSqlSessionFactory(DataSource orderDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(orderDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/order/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "orderSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate orderSqlSessionTemplate(@Qualifier("orderSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
