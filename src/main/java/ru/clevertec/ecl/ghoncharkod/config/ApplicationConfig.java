package ru.clevertec.ecl.ghoncharkod.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import ru.clevertec.ecl.ghoncharkod.model.connection.ConnectionPool;
import ru.clevertec.ecl.ghoncharkod.model.connection.HikariCPConnectionPool;
import ru.clevertec.ecl.ghoncharkod.model.dao.*;
import ru.clevertec.ecl.ghoncharkod.model.dao.mapper.CertificateMapper;
import ru.clevertec.ecl.ghoncharkod.model.dao.mapper.GiftCertificateMapper;
import ru.clevertec.ecl.ghoncharkod.model.dao.mapper.TagMapper;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {
    @Bean
    public ConnectionPool connectionPool(){
        return new HikariCPConnectionPool();
    }
    @Bean
    public DataSource dataSource() {
        return connectionPool().getDataSource();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public TagMapper tagMapper() {
        return new TagMapper();
    }

    @Bean
    public TagDao tagDao() {
        return new SimpleTagDao(jdbcTemplate(), tagMapper());
    }
    @Bean
    public CertificateMapper certificateMapper(){
        return new CertificateMapper();
    }
    @Bean
    public CertificateTagDao certificateTagDao(){
        return new SimpleCertificateDao(jdbcTemplate(),certificateMapper());
    }
    @Bean
    public GiftCertificateMapper giftCertificateMapper(){
        return new GiftCertificateMapper();
    }
    @Bean
    public GiftCertificateDao giftCertificateDao(){
        return new SimpleGiftCertificateDao(jdbcTemplate(),giftCertificateMapper());
    }

}
