package druginfo.service.metrics.repository;

import druginfo.service.metrics.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PgStatisticRepository extends JpaRepository<PgStatisticResult, String> {

        @Query(value = "SELECT * FROM pg_stat_user_tables", nativeQuery = true)
        List<PgStatisticResult> findAll();

        @Query(value = "select n.nspname as table_schema,\n" +
                        "       c.relname as table_name,\n" +
                        "       c.reltuples as rows\n" +
                        "from pg_class c\n" +
                        "join pg_namespace n on n.oid = c.relnamespace\n" +
                        "where c.relkind = 'r'\n" +
                        "      and n.nspname not in ('information_schema','pg_catalog')\n" +
                        "order by c.reltuples desc;", nativeQuery = true)
        List<TableRowResult> findTableRows();

        @Query(value = "SELECT 'otc_count' AS otc_total_row, COUNT(*) FROM drugbank05_drugs_products where otc = 'TRUE'\n"
                        +
                        "UNION\n" +
                        "SELECT  'approved_counts' AS otc_total_row, COUNT(*) FROM drugbank05_drugs_products where approved = 'TRUE'\n"
                        +
                        "UNION\n" +
                        "SELECT  'generic_counts' AS otc_total_row, COUNT(*) FROM drugbank05_drugs_products where generic = 'TRUE'", nativeQuery = true)
        List<QueryCountModel> getOtcApprovedGenericCount();

        @Query(value = "SELECT 'US_approved' AS query_count, COUNT(*) FROM drugbank05_drugs_products where country = 'US'\n"
                        +
                        "UNION\n" +
                        "SELECT  'Canada_approved' AS query_count, COUNT(*) FROM drugbank05_drugs_products where country = 'Canada'\n"
                        +
                        "UNION\n" +
                        "SELECT  'EU_approved' AS query_count, COUNT(*) FROM drugbank05_drugs_products where country = 'EU'", nativeQuery = true)
        List<QueryCountModel> getProductsTypeCountByCountry();

        @Query(value = "SELECT 'US_approved' AS query_count, COUNT(*) FROM drugbank05_drugs_products where country = 'US'\n"
                        +
                        "UNION\n" +
                        "SELECT  'Canada_approved' AS query_count, COUNT(*) FROM drugbank05_drugs_products where country = 'Canada'\n"
                        +
                        "UNION\n" +
                        "SELECT  'EU_approved' AS query_count, COUNT(*) FROM drugbank05_drugs_products where country = 'EU'", nativeQuery = true)
        List<QueryCountModel> getProductTypeByTop25Diases();

        @Query(value = "SELECT 'drugs_products' AS table_total_row, COUNT(*) FROM drugbank05_drugs_products\n" +
                        "UNION\n" +
                        "SELECT 'drugs_general_info_full' AS table_total_row, COUNT(*) FROM drugbank05_drugs_general_info_full\n"
                        +
                        "UNION\n" +
                        "SELECT 'drugs_interactions' AS table_total_row, COUNT(*) FROM drugbank05_drugs_interactions\n"
                        +
                        "UNION\n" +
                        "SELECT 'drugs_group' AS table_total_row, COUNT(*) FROM drugbank05_drugs_group\n" +
                        "UNION\n" +
                        "SELECT 'pill_images_detail_data' AS table_total_row, COUNT(*) FROM drugbank05_pill_images_detail_data\n"
                        +
                        "UNION\n" +
                        "SELECT 'pill_images_directory' AS table_total_row, COUNT(*) FROM drugbank05_pill_images_directory\n"
                        +
                        "UNION\n" +
                        "SELECT 'drug2enzyme' AS table_total_row, COUNT(*) FROM drugbank05_drug2enzyme\n" +
                        "UNION\n" +
                        "SELECT 'drug2target' AS table_total_row, COUNT(*) FROM drugbank05_drug2target\n" +
                        "UNION\n" +
                        "SELECT 'drug2transporter' AS table_total_row, COUNT(*) FROM drugbank05_drug2transporter", nativeQuery = true)
        List<CountModel> getTotalRowsAllTable();

}
