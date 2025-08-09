package org.example.springboot2pra07.config;


import org.example.springboot2pra07.conditional.MysqlCondition_22;
import org.example.springboot2pra07.conditional.OracleCondition_22;

import org.example.springboot2pra07.db.DbConfigBean_22;
import org.example.springboot2pra07.db.MysqlDbConfigBean_22;
import org.example.springboot2pra07.db.OracleDbConfigBean_22;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DbConfig {
    @Primary
    @Bean
    @Conditional(MysqlCondition_22.class)
    public DbConfigBean_22 mysql() {
        return new MysqlDbConfigBean_22();
    }

    @Bean
    @Conditional(OracleCondition_22.class)
    public DbConfigBean_22 oracle() {
        return new OracleDbConfigBean_22();
    }
}
