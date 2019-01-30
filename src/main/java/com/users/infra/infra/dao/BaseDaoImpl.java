package com.users.infra.infra.dao;

import com.users.dao.UserMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BaseDaoImpl  {

    @Value("${driver}")
    private String driver;

    @Value("${url}")
    private String url;

    @Value("${dbuser}")
    private String dbUser;

    @Value("${dbpassword}")
    private String dbPassword;

    @Value("${envname}")
    private String envName;

    protected SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void SqlSessionFactory(){
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver(driver);
        pooledDataSource.setUrl(url);
        pooledDataSource.setUsername(dbUser);
        pooledDataSource.setPassword(dbPassword);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment =
                new Environment(envName, transactionFactory, pooledDataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapper.class);
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(configuration);

    }
}