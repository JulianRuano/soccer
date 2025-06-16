package com.hexagonal.soccer.infrastructure.adapters.output.multitenancy;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DelegatingDataSource;
import java.sql.Connection;

public class TenantAwareDataSource extends DelegatingDataSource {
     public TenantAwareDataSource(DataSource targetDataSource) {
        super(targetDataSource);
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = super.getConnection();
        setTenant(connection);
        return connection;
    }

    private void setTenant(Connection connection) throws SQLException {
        String tenantId = TenantContext.getTenantId();
        if (tenantId != null) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "SET app.current_tenant = ?")) {
                stmt.setString(1, tenantId);
                stmt.execute();
            }
        }
    }
}
