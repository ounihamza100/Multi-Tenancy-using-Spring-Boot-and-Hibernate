package io.houni.multitenancyspringboothibernate.context;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hamza Ouni
 */
public interface DataSourceConfigRepository extends JpaRepository<DataSourceConfig, Long> {
    DataSourceConfig findByName(String name);
}