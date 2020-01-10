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
@MapperScan(basePackages = {"io.ilss.transaction.twodatasource.dao.account"}, sqlSessionTemplateRef = "accountSqlSessionTemplate")
public class AccountConfiguration {

    @Bean(name = "accountDataSource")
    public DataSource accountDataSource() {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidXADataSource.setUsername("root");
        druidXADataSource.setPassword("feng1104");
        druidXADataSource.setDbType("mysql");
        druidXADataSource.setUrl("jdbc:mysql://127.0.0.1:3306/transaction_account?useSSL=false&characterEncoding=UTF-8");
        atomikosDataSourceBean.setXaDataSource(druidXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("accountDataSource");
        return atomikosDataSourceBean;
    }

    @Bean(name = "accountSqlSessionFactory")
    public SqlSessionFactory accountSqlSessionFactory(DataSource accountDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(accountDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/account/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "accountSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate accountSqlSessionTemplate(@Qualifier("accountSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
